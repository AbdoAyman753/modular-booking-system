package com.mentorship.flight_api.services;

import com.mentorship.flight_api.config.AmadeusApiConfig;
import com.mentorship.flight_api.dtos.BookingRequest;
import com.mentorship.flight_api.dtos.BookingResponse;
import com.mentorship.flight_api.dtos.ConfirmPriceRequest;
import com.mentorship.flight_api.dtos.ConfirmPriceResponse;
import com.mentorship.flight_api.services.interfaces.IFlightBookingBehaviour;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AmadeusFlightBookingService implements IFlightBookingBehaviour {

    private final AmadeusWebClientService amadeusWebClientService;
    private final AmadeusApiConfig amadeusApiConfig;
    private final AmadeusAuthService amadeusAuthService;

    public AmadeusFlightBookingService(AmadeusWebClientService amadeusWebClientService,
                                       AmadeusApiConfig amadeusApiConfig,
                                       AmadeusAuthService amadeusAuthService) {
        this.amadeusWebClientService = amadeusWebClientService;
        this.amadeusApiConfig = amadeusApiConfig;
        this.amadeusAuthService = amadeusAuthService;
    }

    public Mono<ConfirmPriceResponse> confirmPrice(ConfirmPriceRequest request) {
        return this.amadeusWebClientService.post(this.amadeusApiConfig.getBaseUrl() + this.amadeusApiConfig.getPricingUrl(),
                        request,
                        MediaType.APPLICATION_JSON,
                        ConfirmPriceResponse.class,
                        this.amadeusAuthService.getAccessToken(),
                        null);
    }

    public Mono<BookingResponse> createBooking(BookingRequest request) {
        return this.amadeusWebClientService.post(this.amadeusApiConfig.getBaseUrl() + this.amadeusApiConfig.getFlightOrdersUrl(),
                request,
                MediaType.APPLICATION_JSON,
                BookingResponse.class,
                this.amadeusAuthService.getAccessToken(),
                null);
    }
}

