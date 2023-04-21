package com.ncgroup.vehiclegenie.dto.models;

import lombok.*;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Vehicle {

    private String title;
    private String sub_title;
    private String price;
    private String brand;
    private String model;
    private String edition;
    private String year;
    private String condition;
    private String transmission;
    private String body;
    private String fuel;
    private String capacity;
    private String mileage;
    private String location;
    private String description;
    private String post_url;
    private String seller_name;
    private String seller_type;
    private String published_date;
    private BigDecimal vehicle_Id;

}
