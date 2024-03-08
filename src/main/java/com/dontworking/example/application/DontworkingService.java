package com.dontworking.example.application;

import com.dontworking.example.application.Domain.Dontworking;
import com.dontworking.example.application.port.DatabasePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DontworkingService {
    private final DatabasePort databasePort;
    public Mono<Void> saveDontworkingData(Dontworking dontworking) {
        return databasePort.saveDontworking(dontworking);
    }

}
