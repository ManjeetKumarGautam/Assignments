package com.example.Restaurant.Service;

import com.example.Restaurant.Entity.Restaurant;
import com.example.Restaurant.Repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepo restaurantRepo;

    public String addRestaurant(List<Restaurant> restaurantList) {
        restaurantRepo.getRestaurantLists().addAll(restaurantList);
        return restaurantList.size()+" restaurants were added";
    }

    public List<Restaurant> getAllRestaurants(){
        return restaurantRepo.getRestaurantLists();
    }

    public Restaurant getRestaurant(Integer id){
        for (Restaurant res: getAllRestaurants()){
            if(res.getRestaurantId().equals(id)){
                return res;
            }
        }
        return null;
    }

    public String updateRestaurantSpecialty(Integer id , String val){
        for (Restaurant res: getAllRestaurants()){
            if(res.getRestaurantId().equals(id)){
                 res.setSpecialty(val);
                 return "Updation Successfully..";
            }
        }
        return "Invalid id...";
    }

    public String deleteRestaurantById(Integer id){
        for (Restaurant res: getAllRestaurants()){
            if(res.getRestaurantId().equals(id)){
                getAllRestaurants().remove(res);
                return "Deletion Successfully..";
            }
        }
        return "Invalid id...";
    }
}
