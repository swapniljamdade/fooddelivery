package com.search.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.search.model.Restaurant;
import com.search.service.FoodDelivery;

@RestController
public class RestaurantController {
	
	@Autowired
	private FoodDelivery foodDelivery;
	
	@RequestMapping("/restaurants/{type}")
	public List<Restaurant> getRestaurantsList(@PathVariable String type){
		return foodDelivery.findForType(Restaurant.Type.valueOf(type));
	}
	
	@RequestMapping(value = "/addRestaurant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addRestaurant(@RequestBody Restaurant restaurantDetails){
		foodDelivery.addRestaurant(restaurantDetails);
	}
}
