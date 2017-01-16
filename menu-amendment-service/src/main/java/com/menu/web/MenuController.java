package com.menu.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.menu.model.Item;
import com.menu.model.Menu;
import com.menu.model.MenuException;

@RestController
public class MenuController {
	
	@Autowired
	private Menu menu;
	
	@RequestMapping("/menu")
	public List<Item> getRestaurantsMenu(){
		return menu.get();
	}
	
	@RequestMapping(value = "/addMenuItem" , method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void addMenuItem(@RequestBody Item item) throws MenuException{
		menu.add(item);
	}
	
	@RequestMapping(value = "/updateMenuItem" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateMenuItem(@RequestBody Item prevItem, @RequestBody Item currItem) throws MenuException{
		menu.update(prevItem, currItem);
	}
	
	@RequestMapping(value = "/removeMenuItem" , method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void removeMenuItem(@RequestBody Item menuItem) throws MenuException{
		menu.remove(menuItem);
	}
}
