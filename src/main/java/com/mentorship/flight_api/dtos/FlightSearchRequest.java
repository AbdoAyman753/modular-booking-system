package com.mentorship.flight_api.dtos;

public record FlightSearchRequest(
        String originLocationCode,
        String destinationLocationCode,
        String departureDate,
        String returnDate,

        Integer adults,
        Integer children,
        Integer infants,

        TravelClass travelClass,    // Enum instead of String
        String includeAirlineCodes,
        String excludeAirlineCodes,

        Boolean nonStop,
        String currencyCode,
        Integer maxPrice,
        Integer max
) {
    public enum TravelClass {
        ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST;

        public static TravelClass fromString(String value) {
            return value != null ? TravelClass.valueOf(value.toUpperCase()) : null;
        }
    }
}

