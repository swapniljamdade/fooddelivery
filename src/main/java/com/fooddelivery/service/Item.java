package com.fooddelivery.service;

import com.google.common.base.Objects;

/**
 * Created by Tomasz_Kozlowski on 1/9/2017.
 */
public class Item {
    private String name;
    private String price;
    private String description;

    public Item(String name, String price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void update(Item item) {
        this.name = item.getName();
        this.price = item.getPrice();
        this.description = item.getDescription();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equal(name, item.name) &&
                Objects.equal(price, item.price) &&
                Objects.equal(description, item.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name, price, description);
    }
}
