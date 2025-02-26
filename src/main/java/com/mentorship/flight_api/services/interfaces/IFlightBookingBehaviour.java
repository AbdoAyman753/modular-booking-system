package com.mentorship.flight_api.services.interfaces;

import com.mentorship.flight_api.dtos.BookingRequest;
import com.mentorship.flight_api.dtos.BookingResponse;
import com.mentorship.flight_api.dtos.ConfirmPriceRequest;
import com.mentorship.flight_api.dtos.ConfirmPriceResponse;
import reactor.core.publisher.Mono;

public interface IFlightBookingBehaviour {
    Mono<ConfirmPriceResponse> confirmPrice(ConfirmPriceRequest request);
    Mono<BookingResponse> createBooking(BookingRequest request);
}
