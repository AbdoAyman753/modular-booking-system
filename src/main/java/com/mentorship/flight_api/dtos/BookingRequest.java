package com.mentorship.flight_api.dtos;

import java.util.List;

public record BookingRequest(
        Data data
) {
    public record Data(
            String type,
            List<FlightOffer> flightOffers,
            List<Traveler> travelers,
            Remarks remarks,
            TicketingAgreement ticketingAgreement,
            List<Contact> contacts
    ) {}

    public record FlightOffer(
            String type,
            String id,
            String source,
            boolean instantTicketingRequired,
            boolean nonHomogeneous,
            boolean paymentCardRequired,
            String lastTicketingDate,
            List<Itinerary> itineraries,
            Price price,
            PricingOptions pricingOptions,
            List<String> validatingAirlineCodes,
            List<TravelerPricing> travelerPricings
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
            String duration,
            String id,
            int numberOfStops
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

    public record IncludedCheckedBags(int quantity) {}

    public record Traveler(
            String id,
            String dateOfBirth,
            Name name,
            String gender,
            Contact contact,
            List<Document> documents
    ) {}

    public record Name(String firstName, String lastName) {}

    public record Phone(String deviceType, String countryCallingCode, String number) {}

    public record Document(
            String documentType,
            String birthPlace,
            String issuanceLocation,
            String issuanceDate,
            String number,
            String expiryDate,
            String issuanceCountry,
            String validityCountry,
            String nationality,
            boolean holder
    ) {}

    public record Remarks(
            List<GeneralRemark> general
    ) {}

    public record GeneralRemark(String subType, String text) {}

    public record TicketingAgreement(
            String option,
            String delay
    ) {}

    public record Contact(
            Name addresseeName,
            String companyName,
            String purpose,
            List<Phone> phones,
            String emailAddress,
            Address address
    ) {}

    public record Address(
            List<String> lines,
            String postalCode,
            String cityName,
            String countryCode
    ) {}
}
