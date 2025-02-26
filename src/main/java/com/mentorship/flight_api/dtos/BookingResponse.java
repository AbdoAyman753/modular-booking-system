package com.mentorship.flight_api.dtos;

import java.util.List;
import java.util.Map;

public record BookingResponse(
        Data data,
        Dictionaries dictionaries
) {
    public record Data(
            String type,
            String id,
            String queuingOfficeId,
            List<AssociatedRecord> associatedRecords,
            List<Traveler> travelers,
            List<FlightOffer> flightOffers
    ) {}

    public record AssociatedRecord(
            String reference,
            String creationDateTime,
            String originSystemCode,
            String flightOfferId
    ) {}

    public record Traveler(
            String id,
            String dateOfBirth,
            Name name,
            Contact contact,
            List<Document> documents
    ) {}

    public record Name(String firstName, String lastName) {}

    public record Contact(
            List<Phone> phones
    ) {}

    public record Phone(String countryCallingCode, String number) {}

    public record Document(
            String documentType,
            String number,
            String expiryDate,
            String issuanceCountry,
            String nationality,
            boolean holder
    ) {}

    public record FlightOffer(
            String id,
            String type,
            String source,
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
            String id,
            String duration,
            Aircraft aircraft,
            int numberOfStops,
            boolean blacklistedInEU,
            String carrierCode,
            Operating operating,
            String number,
            Departure departure,
            Arrival arrival,
            List<CO2Emission> co2Emissions
    ) {}

    public record Departure(String at, String terminal, String iataCode) {}
    public record Arrival(String at, String terminal, String iataCode) {}
    public record Aircraft(String code) {}
    public record Operating(String carrierCode) {}

    public record CO2Emission(
            String weight,
            String weightUnit,
            String cabin
    ) {}

    public record Price(
            String grandTotal,
            String total,
            String base,
            String currency,
            String billingCurrency,
            List<Fee> fees,
            List<AdditionalService> additionalServices
    ) {}

    public record Fee(String type, String amount) {}

    public record AdditionalService(String type, String amount) {}

    public record PricingOptions(
            List<String> fareType,
            boolean includedCheckedBags
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
            String brandedFare,
            String classType,
            boolean isAllotment,
            AllotmentDetails allotmentDetails,
            String sliceDiceIndicator,
            IncludedCheckedBags includedCheckedBags
    ) {}

    public record AllotmentDetails(String tourName, String tourReference) {}

    public record IncludedCheckedBags(int quantity) {}

    public record Dictionaries(
            Map<String, Location> locations
    ) {}

    public record Location(
            String cityCode,
            String countryCode
    ) {}
}

