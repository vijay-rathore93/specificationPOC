package com.example.specification;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Address {

    @Id
    @GeneratedValue
    private Integer addressId;
    private String city;
    private String country;
    private Integer userId;
}
