package com.example.Restaurant.Controller;

import com.example.Restaurant.Entity.Restaurant;
import com.example.Restaurant.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("restaurants")
    public String addRestaurants(@RequestBody List<Restaurant> restaurantList){
        return restaurantService.addRestaurant(restaurantList);
    }

    @GetMapping("restaurants")
    public List<Restaurant> getRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("restaurant/id/{id}")
    public Restaurant  getRestaurant(@PathVariable Integer id){
        return restaurantService.getRestaurant(id);
    }

    @PutMapping("restaurant/id/{id}/")
    public String updateRestaurantSpeciality(@PathVariable Integer id, @RequestParam String val){
        return restaurantService.updateRestaurantSpecialty(id,val);
    }

    @DeleteMapping("restaurant/id/{id}")
    public String deleteRestaurant(@PathVariable Integer id){
        return restaurantService.deleteRestaurantById(id);
    }
}
