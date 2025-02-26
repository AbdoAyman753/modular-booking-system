package com.mentorship.flight_api.services;

import com.mentorship.flight_api.services.interfaces.IntegrationWebClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class AmadeusWebClientService implements IntegrationWebClient {

    private final WebClient webClient;

    public AmadeusWebClientService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.build();
    }

    /**
     * Generic POST request with optional headers and body.
     */
    public <T, R> Mono<R> post(String url, T body, MediaType contentType,
                               Class<R> responseType, String accessToken, Map<String, String> extraHeaders) {

        WebClient.RequestBodySpec requestSpec = webClient.post()
                .uri(url)
                .headers(headers -> setHeaders(headers, accessToken, extraHeaders))
                .contentType(contentType);

        if (contentType.equals(MediaType.APPLICATION_FORM_URLENCODED) && body instanceof BodyInserters.FormInserter) {
            requestSpec.body((BodyInserters.FormInserter<?>) body);
        } else {
            requestSpec.bodyValue(body);
        }
        return requestSpec.retrieve().bodyToMono(responseType);
    }

    /**
     * Generic GET request with optional headers.
     */
    public <R> Mono<R> get(String url, Class<R> responseType, String accessToken, Map<String, String> extraHeaders) {
        return webClient.get()
                .uri(url)
                .headers(headers -> setHeaders(headers, accessToken, extraHeaders))
                .retrieve()
                .bodyToMono(responseType);
    }

    /**
     * Generic PUT request with optional headers and body.
     */
    public <T, R> Mono<R> put(String url, T body, MediaType contentType,Class<R> responseType, String accessToken, Map<String, String> extraHeaders) {
        return webClient.put()
                .uri(url)
                .headers(headers -> setHeaders(headers, accessToken, extraHeaders))
                .contentType(contentType)
                .bodyValue(body)
                .retrieve()
                .bodyToMono(responseType);
    }

    /**
     * Generic DELETE request with optional headers.
     */
    public Mono<Void> delete(String url, String accessToken, Map<String, String> extraHeaders) {
        return webClient.delete()
                .uri(url)
                .headers(headers -> setHeaders(headers, accessToken, extraHeaders))
                .retrieve()
                .bodyToMono(Void.class);
    }

    /**
     * Helper method to set headers.
     */
    private void setHeaders(HttpHeaders headers, String accessToken, Map<String, String> extraHeaders) {
        if (accessToken != null) {
            headers.set(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        }
        if (extraHeaders != null) {
            extraHeaders.forEach(headers::set);
        }
    }
}

