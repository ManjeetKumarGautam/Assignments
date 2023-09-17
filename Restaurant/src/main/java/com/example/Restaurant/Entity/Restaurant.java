package com.example.Restaurant.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    private Integer restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private Dietary dietary;
    private String number;
    private String specialty;
    private String totalStaffs;
    private Delivery delivery;
}




