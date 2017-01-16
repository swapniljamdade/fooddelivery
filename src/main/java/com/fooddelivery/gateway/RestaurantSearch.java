package com.fooddelivery.gateway;

import java.util.List;

import com.fooddelivery.model.Restaurant;
import com.fooddelivery.model.Restaurant.Type;

public interface RestaurantSearch {
	
	public List<Restaurant> findForType(Type valueOf);
	
	public void addRestaurant(Restaurant restaurantData);


}
