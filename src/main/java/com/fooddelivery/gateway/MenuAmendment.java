package com.fooddelivery.gateway;

import java.util.List;

import com.fooddelivery.service.Item;
import com.fooddelivery.service.Menu;

public interface MenuAmendment {
	
	public List<Menu> getMenu();
	
	public void addMenuItem(Item item);
	
	public void updateMenuItem(Item prevItem, Item currItem);
	
	public void deleteMenuItem(Item item);
}
