package com.mentorship.flight_api.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "amadeus.api")
@Data
public class AmadeusApiConfig {
    private String clientId;
    private String clientSecret;
    private String baseUrl;
    private String flightSearchUrl;
    private String pricingUrl;
    private String flightOrdersUrl;
    private String securityUrl;
}
