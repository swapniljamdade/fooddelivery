package com.epam.jmp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tomasz_Kozlowski on 1/9/2017.
 */
public class Menu {
    private List<Item> items = new LinkedList<>();

    public void add(Item item) throws MenuException {
        if (items.contains(item)) throw new MenuException("Item already exists in Menu: " + item);
        items.add(item);
    }

    public void remove(Item item) throws MenuException {
        if(!items.contains(item)) throw new MenuException("Item not exist in Menu: " + item);
        items.remove(item);
    }

    public void update(final Item prev, Item curr) throws MenuException {
        items.stream().filter(item -> item.equals(prev)).findFirst().orElseThrow(() -> new MenuException("")).update(curr);
    }

    public List<Item> get() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }
}
