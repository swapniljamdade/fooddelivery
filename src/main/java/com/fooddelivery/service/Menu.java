package com.fooddelivery.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tomasz_Kozlowski on 1/9/2017.
 */
public class Menu {
    private List<Item> items = new LinkedList<>();

    public List<Item> get() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }
}
