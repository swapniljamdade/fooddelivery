package com.fooddelivery.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fooddelivery.gateway.MenuAmendment;
import com.fooddelivery.gateway.RestaurantSearch;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.service.Item;
import com.fooddelivery.service.Order;

@RestController
public class FoodDeliveryController {
	
	@Autowired
	private RestaurantSearch restaurantSearchGateway;
	
	@Autowired
	private MenuAmendment menuAmendmentGateway;
	
	@Autowired
	private Order order;

	@RequestMapping("/restaurants/{type}")
	public List<Restaurant> getRestaurantsList(@PathVariable String type){
		return restaurantSearchGateway.findForType(Restaurant.Type.valueOf(type));
	}
	
	@RequestMapping(value = "/addRestaurant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addRestaurant(@RequestBody Restaurant restaurantDetails){
		restaurantSearchGateway.addRestaurant(restaurantDetails);
	}
	
	@RequestMapping(value = "/menu", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void getMenu(){
		menuAmendmentGateway.getMenu();
	}
	
	@RequestMapping(value = "/addMenuItem", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addMenuItem(@RequestBody Item item){
		menuAmendmentGateway.addMenuItem(item);
	}
	
	@RequestMapping(value = "/updateMenuItem", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateMenuItem(@RequestBody Item prevItem, @RequestBody Item currItem){
		menuAmendmentGateway.updateMenuItem(prevItem, currItem);
	}
	
	@RequestMapping(value = "/removeMenuItem", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void removeMenuItem(@RequestBody Item item){
		menuAmendmentGateway.deleteMenuItem(item);
	}
	
	@RequestMapping(value = "/addItemToOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addItemToOrder(@RequestBody Item item){
		order.addItem(item);
	}
	
	@RequestMapping(value = "/removeItemFromOrder", method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void removeMenuItemFromOrder(@RequestBody Item item){
		order.removeItem(item);
	}
}
