package com.fooddelivery.gateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fooddelivery.model.Restaurant;
import com.fooddelivery.model.Restaurant.Type;

@Component
public class RestaurantSearchGateway implements RestaurantSearch {

	@Autowired
	private RestTemplate restTemplate;

	public List<Restaurant> findForType(Type type) {
		ParameterizedTypeReference<List<Restaurant>> responseType = new ParameterizedTypeReference<List<Restaurant>>() {};
		ResponseEntity<List<Restaurant>> exchange = this.restTemplate.exchange("http://restaurant-search-service/restaurants/"+type, 
			HttpMethod.GET,null, responseType, (Object) "pwebb");
		return exchange.getBody();
	}
	
	public void addRestaurant(Restaurant restaurantData) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	
		MultiValueMap<Restaurant, String> map= new LinkedMultiValueMap<>();
	
		HttpEntity<MultiValueMap<Restaurant, String>> request = new HttpEntity<>(map, headers);
	
		restTemplate.postForEntity("http://restaurant-search-service/addRestaurant", request , String.class );
	}

}
