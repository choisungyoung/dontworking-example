package com.dontworking.example.infrastructure.persistence.dynamo.entity;

import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

@Builder
@Data
@AllArgsConstructor
@DynamoDbBean
public class DontworkingEntity {
    private String id;
    private String name;
    private String data;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}