package com.fooddelivery.service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tomasz_Kozlowski on 1/12/2017.
 */
public class Order {
    private int userId;
    private int id;
    private int restaurantId;
    private Map<Item, Integer> items;
    private boolean isActive;
    private String totalPrice;
    private DecimalFormat df = new DecimalFormat("#.##");

    public Order(int userId, int id, int restaurantId) {
        this.userId = userId;
        this.id = id;
        this.restaurantId = restaurantId;
        items = new HashMap<>();
        isActive = true;
        totalPrice = "0.0";
        df.setRoundingMode(RoundingMode.CEILING);
    }

    public void addItem(Item item) {
        if(!items.containsKey(item)) items.put(item, 1);
        else items.put(item, items.get(item) + 1);
        updatePrice(item.getPrice());
    }

    private void updatePrice(String price) {
        totalPrice = String.valueOf(df.format(Double.parseDouble(price) + Double.parseDouble(totalPrice)));
    }

    public String getPrice() {
        return totalPrice;
    }

    public void removeItem(Item item) {
        items.remove(item);
        totalPrice = String.valueOf(df.format(Double.parseDouble(totalPrice) - Double.parseDouble(item.getPrice())));
    }

    public Map<Item, Integer> get() {
        return new HashMap<>(items);
    }

    public boolean isActive() {
        return isActive;
    }

    public void cancel() {
        isActive = false;
    }
}
