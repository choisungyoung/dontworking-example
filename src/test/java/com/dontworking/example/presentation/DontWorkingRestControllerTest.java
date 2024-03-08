package com.dontworking.example.presentation;

import com.dontworking.example.application.Domain.Dontworking;
import com.dontworking.example.application.DontworkingService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@Slf4j
@WebFluxTest(DontWorkingRestController.class)
class DontWorkingRestControllerTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void getTestData() {
        this.webClient.get().uri("/dontworking/getTestData").accept(MediaType.TEXT_PLAIN)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo("TEST DATA")
                .value(result -> log.info("result : {}", result));
    }
}