package com.dontworking.example.infrastructure.persistence.dynamo;

import com.dontworking.example.infrastructure.persistence.dynamo.entity.DontworkingEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import software.amazon.awssdk.enhanced.dynamodb.*;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ReactiveDynamoRepository {
    private final DynamoDbEnhancedAsyncClient enhancedAsyncClient;

    public Mono<Void> saveDontworkingEntity(DontworkingEntity entity) {
        DynamoDbAsyncTable<DontworkingEntity> table = enhancedAsyncClient.table("DONTWORKING_TEST", TableSchema.fromBean(DontworkingEntity.class));
        return Mono.fromFuture(table.putItem(entity));
    }

    public Flux<DontworkingEntity> findAllDontworkingEntity() {
        DynamoDbAsyncTable<DontworkingEntity> table = enhancedAsyncClient.table("DONTWORKING_TEST", TableSchema.fromBean(DontworkingEntity.class));

        QueryEnhancedRequest queryEnhancedRequest = QueryEnhancedRequest.builder()
                .queryConditional(QueryConditional.keyEqualTo(Key.builder()
                        .build()))
                .build();

        return Flux.from(table.query(queryEnhancedRequest).items());
    }
}
