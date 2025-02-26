package com.mentorship.flight_api.dtos;

import java.util.List;
import java.util.Map;

public record ConfirmPriceResponse(
        Data data,
        Map<String, Location> dictionaries
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
            String lastTicketingDate,
            List<Itinerary> itineraries,
            Price price,
            PricingOptions pricingOptions,
            List<String> validatingAirlineCodes,
            List<TravelerPricing> travelerPricings,
            boolean paymentCardRequired
    ) {}

    public record Itinerary(
            List<Segment> segments
    ) {}

    public record Segment(
            Departure departure,
            Arrival arrival,
            String carrierCode,
            String number,
            Aircraft aircraft,
            Operating operating,
            String id,
            int numberOfStops,
            String duration
    ) {}

    public record Departure(String iataCode, String at, String terminal) {}
    public record Arrival(String iataCode, String at, String terminal) {}
    public record Aircraft(String code) {}
    public record Operating(String carrierCode) {}

    public record Price(
            String currency,
            String total,
            String base,
            List<Fee> fees,
            String grandTotal,
            String billingCurrency
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
            int quantity
    ) {}

    public record Location(
            String cityCode,
            String countryCode
    ) {}
}

