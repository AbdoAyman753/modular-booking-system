package com.mentorship.flight_api.services.interfaces;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface IntegrationWebClient {
    /**
     * Generic POST request with optional headers and body.
     */
    public <T, R> Mono<R> post(String url, T body, MediaType contentType,
                               Class<R> responseType, String accessToken, Map<String, String> extraHeaders);

    /**
     * Generic GET request with optional headers.
     */
    public <R> Mono<R> get(String url, Class<R> responseType, String accessToken, Map<String, String> extraHeaders);

    /**
     * Generic PUT request with optional headers and body.
     */
    public <T, R> Mono<R> put(String url, T body, MediaType contentType,Class<R> responseType, String accessToken, Map<String, String> extraHeaders);

    /**
     * Generic DELETE request with optional headers.
     */
    public Mono<Void> delete(String url, String accessToken, Map<String, String> extraHeaders);

    /**
     * Helper method to set headers.
     */
    private void setHeaders(HttpHeaders headers, String accessToken, Map<String, String> extraHeaders) {}
}
