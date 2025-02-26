package com.mentorship.flight_api.dtos;

import java.util.List;

public record ConfirmPriceRequest(
        Data data
) {
    public record Data(
            String type,
            List<FlightOffer> flightOffers
    ) {}

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
    ) {}

    public record Itinerary(
            String duration,
            List<Segment> segments
    ) {}

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
    ) {}

    public record Departure(String iataCode, String terminal, String at) {}
    public record Arrival(String iataCode, String terminal, String at) {}
    public record Aircraft(String code) {}
    public record Operating(String carrierCode) {}

    public record Price(
            String currency,
            String total,
            String base,
            List<Fee> fees,
            String grandTotal
    ) {}

    public record Fee(String amount, String type) {}

    public record PricingOptions(
            List<String> fareType,
            boolean includedCheckedBagsOnly
    ) {}

    public record TravelerPricing(
            String travelerId,
            String fareOption,
            String travelerType,
            Price price,
            List<FareDetailsBySegment> fareDetailsBySegment
    ) {}

    public record FareDetailsBySegment(
            String segmentId,
            String cabin,
            String fareBasis,
            String classType,
            IncludedCheckedBags includedCheckedBags
    ) {}

    public record IncludedCheckedBags(
            int weight,
            String weightUnit
    ) {}
}

