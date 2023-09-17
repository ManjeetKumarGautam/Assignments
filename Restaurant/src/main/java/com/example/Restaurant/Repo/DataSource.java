package com.example.Restaurant.Repo;

import com.example.Restaurant.Entity.Restaurant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataSource {
    @Bean
    List<Restaurant> restaurantSource(){
        return new ArrayList<>();
    }
}
