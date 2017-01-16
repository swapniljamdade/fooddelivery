package com.epam.jmp;

import org.junit.Test;

import com.fooddelivery.service.Item;
import com.fooddelivery.service.Order;

import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomasz_Kozlowski on 1/12/2017.
 */
public class OrderTest {

    @Test
    public void testAddItem() {
        Order order = new Order(1, 1, 1);
        Item item1 = new Item("a", "33.1", "aaa");
        Item item2 = new Item("b", "33.4", "bbb");
        order.addItem(item1);
        order.addItem(item1);
        order.addItem(item2);
        Map<Item, Integer> items = order.get();
        assertEquals(2, items.get(item1).intValue());
        assertEquals(1, items.get(item2).intValue());
    }

    @Test
    public void testCheckImmutability() {
        Order order = new Order(1, 1, 1);
        Item item1 = new Item("a", "33.1", "aaa");
        Item item2 = new Item("b", "33.4", "bbb");
        order.addItem(item1);
        order.addItem(item1);
        order.addItem(item2);
        Map<Item, Integer> items = order.get();
        items.put(item1, 30);

        Map<Item, Integer> itemsImm = order.get();
        assertEquals(2, itemsImm.get(item1).intValue());
        assertEquals(1, itemsImm.get(item2).intValue());
    }

    @Test
    public void testPrice() {
        Order order = new Order(1, 1, 1);
        Item item1 = new Item("a", "10.12", "aaa");
        Item item2 = new Item("b", "20.21", "bbb");
        Item item3 = new Item("c", "30.36", "aaa");
        Item item4 = new Item("d", "40.49", "bbb");

        assertEquals("0.0", order.getPrice());

        order.addItem(item1);
        assertEquals("10.12", order.getPrice());

        order.addItem(item1);
        assertEquals("20.24", order.getPrice());

        order.addItem(item2);
        assertEquals("40.45", order.getPrice());

    }

}
