package com.dontworking.example.application.port;

import com.dontworking.example.application.Domain.Dontworking;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface DatabasePort {
    Mono<Void> saveDontworking(Dontworking dontworking);

    Flux<Dontworking> findAllDontworking();
}
