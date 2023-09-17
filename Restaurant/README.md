# Readme file of Restaurant

## Framework and Language 
* ### Framework
  * Spring Boot
* ### Language
  * Java
 
## Data Flow
### 1. Controller
```JAVA
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
```

### 2. Services
```JAVA
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
```
### 3. Repository
```JAVA
public class RestaurantRepo {
    @Autowired
    private List<Restaurant> restaurantList;

    public List<Restaurant> getRestaurantLists(){
        return restaurantList;
    }
}
```


### 4. Data Base
```JAVA
public class DataSource {
    @Bean
    List<Restaurant> restaurantSource(){
        return new ArrayList<>();
    }
}
```

## Data Structure
*  ArrayList
*  Linear Search

## Project Summary
