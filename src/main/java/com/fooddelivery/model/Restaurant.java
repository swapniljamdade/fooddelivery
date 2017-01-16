package com.fooddelivery.model;

import com.fooddelivery.service.Menu;

public class Restaurant {
    private int id;
    private String name;
    private Type type;
    private String location;
    private Menu menu;

    public Restaurant(int id, String name, Type type, String location, Menu menu) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
        this.menu = menu;
    }
    
    public Restaurant(){}

    public Type getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public Menu getMenu() {
        return menu;
    }

    public enum Type {
        INDIAN(1),
        CHINESE(2),
        BRITISH(3),
        PIZZERIA(4),
        ITALIAN(5),
        POLISH(6);

        Type(int i) {

        }
    }
}
