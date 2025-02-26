package com.mentorship.flight_api.controllers;

import com.mentorship.flight_api.dtos.BookingRequest;
import com.mentorship.flight_api.dtos.BookingResponse;
import com.mentorship.flight_api.dtos.ConfirmPriceRequest;
import com.mentorship.flight_api.dtos.ConfirmPriceResponse;
import com.mentorship.flight_api.services.AmadeusFlightBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api/flight")
public class FlightBookingController {
    private final AmadeusFlightBookingService amadeusFlightBookingService;

    public FlightBookingController(AmadeusFlightBookingService amadeusFlightBookingService) {
        this.amadeusFlightBookingService = amadeusFlightBookingService;
    }

    @PostMapping("/confirm-price")
    public Mono<ResponseEntity<ConfirmPriceResponse>> confirmPrice(@RequestBody ConfirmPriceRequest request) {
        return amadeusFlightBookingService.confirmPrice(request)
                .map(ResponseEntity::ok);
    }

    @PostMapping("/create-order")
    public Mono<ResponseEntity<BookingResponse>> createBooking(@RequestBody BookingRequest request) {
        return amadeusFlightBookingService.createBooking(request)
                .map(ResponseEntity::ok);
    }
}



