package com.dontworking.example.infrastructure.persistence.dynamo;

import com.dontworking.example.infrastructure.persistence.dynamo.entity.DontworkingEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReactiveDynamoRepositoryTest {

    @Autowired
    ReactiveDynamoRepository reactiveDynamoRepository;

    @Test
    void saveDontworkingEntity() {
        DontworkingEntity entity1 = DontworkingEntity.builder()
                .id("1000")
                .name("홍길동")
                .data("길동's DATA")
                .build();
        DontworkingEntity entity2 = DontworkingEntity.builder()
                .id("1001")
                .name("김철수")
                .data("철수's DATA")
                .build();

        reactiveDynamoRepository.saveDontworkingEntity(entity1)
                .subscribe();
    }

    @Test
    void findAllDontworkingEntity() {
    }
}