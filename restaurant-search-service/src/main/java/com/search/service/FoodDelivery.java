package com.search.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.search.model.Location;
import com.search.model.Restaurant;

/**
 * Created by Tomasz_Kozlowski on 1/9/2017.
 TASK:
 1) User can search different restaurant
 2) User can select a restaurant
 3) User sees a menu
 4) Restaurant can change the menu any time
 5) User adds an item from menu
 6) User orders the food
 7) User can track the order in real time
 8) User can cancel the order
 9) User pays for the order
 */

@Component
public class FoodDelivery {
    private List<Restaurant> restaurants = Lists.newLinkedList();

    public void addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
    }

    public void addBulk(List<Restaurant> bulk) {
        restaurants.addAll(bulk);
    }

    public List<Restaurant> findForType(Restaurant.Type type) {
        return restaurants.stream().filter(restaurant -> restaurant.getType().equals(type)).collect(Collectors.toList());
    }
}
