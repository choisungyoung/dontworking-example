package com.dontworking.example.application.Domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Dontworking {
    private String id;
    private String name;
    private String data;
}
