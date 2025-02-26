package com.mentorship.flight_api.services.interfaces;

import com.mentorship.flight_api.dtos.FlightSearchRequest;
import com.mentorship.flight_api.dtos.FlightSearchResponse;
import reactor.core.publisher.Mono;

public interface IFlightSearchBehaviour {

    Mono<FlightSearchResponse> searchFlights(FlightSearchRequest request);
}
