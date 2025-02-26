package com.mentorship.flight_api.services;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mentorship.flight_api.config.AmadeusApiConfig;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;

import java.time.Instant;

@Service
public class AmadeusAuthService {

    private final AmadeusWebClientService amadeusWebClientService;
    private final AmadeusApiConfig config;
    private String accessToken;
    private Instant tokenExpiry;

    public AmadeusAuthService(AmadeusWebClientService amadeusWebClientService, AmadeusApiConfig config) {
        this.amadeusWebClientService = amadeusWebClientService;
        this.config = config;
    }

    public String getAccessToken() {
        if (accessToken != null && Instant.now().isBefore(tokenExpiry)) {
            return accessToken;
        }

        // separate in a function for code readability
        return amadeusWebClientService.post(this.config.getBaseUrl() + this.config.getSecurityUrl(),
                BodyInserters.fromFormData("grant_type", "client_credentials")
                        .with("client_id", config.getClientId())
                        .with("client_secret", config.getClientSecret()),
                MediaType.APPLICATION_FORM_URLENCODED,
                TokenResponse.class,
                null,
                null
        ).map(response -> {
            this.accessToken = response.getAccessToken();
            this.tokenExpiry = Instant.now().plusSeconds(response.getExpiresIn() - 60);
            return accessToken;
        }).block();
    }

    @Data
    private static class TokenResponse {
        @JsonProperty("access_token")
        private String accessToken;
        @JsonProperty("expires_in")
        private long expiresIn;
    }
}

