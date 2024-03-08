package com.dontworking.example.presentation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/dontworking")
public class DontWorkingRestController {

    @GetMapping("/getTestData")
    public Mono<? extends ResponseEntity<?>> getTestData() {
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body("TEST DATA"));
    }
}
