package com.mentorship.flight_api.controllers;

import com.mentorship.flight_api.dtos.FlightSearchRequest;
import com.mentorship.flight_api.dtos.FlightSearchResponse;
import com.mentorship.flight_api.services.AmadeusFlightSearchingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/flight")
public class FlightSearchingController {
    private final AmadeusFlightSearchingService amadeusFlightSearchingService;

    public FlightSearchingController(AmadeusFlightSearchingService amadeusFlightSearchingService) {
        this.amadeusFlightSearchingService = amadeusFlightSearchingService;
    }

    @PostMapping("/search")
    public Mono<ResponseEntity<FlightSearchResponse>> searchFlights(@RequestBody FlightSearchRequest request) {
        return this.amadeusFlightSearchingService.searchFlights(request).map(ResponseEntity::ok);
    }
}
