package com.dontworking.example.presentation;

import com.dontworking.example.application.Domain.Dontworking;
import com.dontworking.example.application.DontworkingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/dontworking")
public class DontWorkingRestController {

    private final DontworkingService dontworkingService;

    @GetMapping("/getTestData")
    public Mono<? extends ResponseEntity<?>> getTestData() {

        Mono<Void> mono = dontworkingService.saveDontworkingData(Dontworking.builder()
                .id("1000")
                .name("홍길동")
                .data("길동's data")
                .build());
        return Mono.just(ResponseEntity.status(HttpStatus.OK).body(mono));
    }
}
