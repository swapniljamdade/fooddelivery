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
import com.fooddelivery.service.Item;
import com.fooddelivery.service.Menu;

@Component
public class MenuAmendmentGateway implements MenuAmendment {

	@Autowired
	private RestTemplate restTemplate;

	public List<Menu> getMenu() {
		ParameterizedTypeReference<List<Menu>> responseType = new ParameterizedTypeReference<List<Menu>>() {};
		ResponseEntity<List<Menu>> exchange = this.restTemplate.exchange("http://menu-amendment-service/menu", 
			HttpMethod.GET,null, responseType, (Object) "pwebb");
		return exchange.getBody();
	}
	
	public void addMenuItem(Item item) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	
		MultiValueMap<String, Item> map= new LinkedMultiValueMap<>();
		map.add(item.getName(), item);
	
		HttpEntity<MultiValueMap<String, Item>> request = new HttpEntity<>(map, headers);
	
		restTemplate.postForEntity("http://restaurant-search-service/addMenuItem", request , String.class );
	}
	
	public void updateMenuItem(Item prevItem, Item currItem) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	
		MultiValueMap<String, Item> map= new LinkedMultiValueMap<>();
		map.add("PrevItem", prevItem);
		map.add("currItem", currItem);
	
		HttpEntity<MultiValueMap<String, Item>> request = new HttpEntity<>(map, headers);
	
		restTemplate.put("http://restaurant-search-service/updateMenuItem", request , String.class );
	}
	
	public void deleteMenuItem(Item item) {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	
		MultiValueMap<String, Item> map= new LinkedMultiValueMap<>();
		map.add(item.getName(), item);
	
		HttpEntity<MultiValueMap<String, Item>> request = new HttpEntity<>(map, headers);
	
		restTemplate.delete("http://restaurant-search-service/removeMenuItem", request , String.class);
	}
	
}
