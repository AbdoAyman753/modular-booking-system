package com.mentorship.flight_api.dtos;

import java.util.List;
import java.util.Map;

public record FlightSearchResponse(
        Meta meta,
        List<FlightOffer> data,
        Dictionaries dictionaries
) {
    public record Meta(
            int count,
            Links links
    ) {
    }

    public record Links(
            String self
    ) {
    }

    public record FlightOffer(
            String type,
            String id,
            String source,
            boolean instantTicketingRequired,
            boolean nonHomogeneous,
            boolean oneWay,
            String lastTicketingDate,
            int numberOfBookableSeats,
            List<Itinerary> itineraries,
            Price price,
            PricingOptions pricingOptions,
            List<String> validatingAirlineCodes,
            List<TravelerPricing> travelerPricings
    ) {
    }

    public record Itinerary(
            String duration,
            List<Segment> segments
    ) {
    }

    public record Segment(
            Departure departure,
            Arrival arrival,
            String carrierCode,
            String number,
            Aircraft aircraft,
            Operating operating,
            String duration,
            String id,
            int numberOfStops,
            boolean blacklistedInEU
    ) {
    }

    public record Departure(
            String iataCode,
            String terminal,
            String at
    ) {
    }

    public record Arrival(
            String iataCode,
            String terminal,
            String at
    ) {
    }

    public record Aircraft(
            String code
    ) {
    }

    public record Operating(
            String carrierCode
    ) {
    }

    public record Price(
            String currency,
            String total,
            String base,
            List<Fee> fees,
            String grandTotal
    ) {
    }

    public record Fee(
            String amount,
            String type
    ) {
    }

    public record PricingOptions(
            List<String> fareType,
            boolean includedCheckedBagsOnly
    ) {
    }

    public record TravelerPricing(
            String travelerId,
            String fareOption,
            String travelerType,
            Price price,
            List<FareDetailsBySegment> fareDetailsBySegment
    ) {
    }

    public record FareDetailsBySegment(
            String segmentId,
            CabinClass cabin,
            String fareBasis,
            String classCode,
            IncludedCheckedBags includedCheckedBags
    ) {
    }

    public record IncludedCheckedBags(
            int weight,
            String weightUnit
    ) {
    }

    public record Dictionaries(
            Map<String, Location> locations,
            Map<String, String> aircraft,
            Map<String, String> currencies,
            Map<String, String> carriers
    ) {
    }

    public record Location(
            String cityCode,
            String countryCode
    ) {
    }

    public enum CabinClass {
        ECONOMY, PREMIUM_ECONOMY, BUSINESS, FIRST
    }
}

