package com.dontworking.example.presentation;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

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