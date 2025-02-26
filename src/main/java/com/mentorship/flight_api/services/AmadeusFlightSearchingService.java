package com.mentorship.flight_api.services;

import com.mentorship.flight_api.config.AmadeusApiConfig;
import com.mentorship.flight_api.dtos.FlightSearchRequest;
import com.mentorship.flight_api.dtos.FlightSearchResponse;
import com.mentorship.flight_api.services.interfaces.IFlightSearchBehaviour;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.lang.reflect.Field;

@Service
public class AmadeusFlightSearchingService implements IFlightSearchBehaviour {
    private final AmadeusWebClientService amadeusWebClientService;
    private final AmadeusApiConfig amadeusApiConfig;
    private final AmadeusAuthService amadeusAuthService;

    public AmadeusFlightSearchingService(AmadeusWebClientService amadeusWebClientService,
                                       AmadeusApiConfig amadeusApiConfig,
                                       AmadeusAuthService amadeusAuthService) {
        this.amadeusWebClientService = amadeusWebClientService;
        this.amadeusApiConfig = amadeusApiConfig;
        this.amadeusAuthService = amadeusAuthService;
    }

    public Mono<FlightSearchResponse> searchFlights(FlightSearchRequest request) {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(this.amadeusApiConfig.getBaseUrl() + this.amadeusApiConfig.getFlightSearchUrl());
        // Use reflection to map all non-null fields dynamically
        for (Field field : request.getClass().getDeclaredFields()) {
            field.setAccessible(true); // Allow access to private fields
            try {
                Object value = field.get(request);
                if (value != null) {
                    uriBuilder.queryParam(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error mapping query parameters", e);
            }
        }

        String url = uriBuilder.encode().toUriString();

        return this.amadeusWebClientService.get(url,
                FlightSearchResponse.class,
                this.amadeusAuthService.getAccessToken(),
                null);
    }
}
