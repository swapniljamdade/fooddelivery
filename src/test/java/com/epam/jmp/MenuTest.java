package com.epam.jmp;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomasz_Kozlowski on 1/12/2017.
 */
public class MenuTest {

    @Test
    public void testAdd() throws MenuException {
        Menu menu = new Menu();
        menu.add(new Item("a", "11.1", "aaa"));
        menu.add(new Item("b", "33.1", "bbb"));
        assertEquals(2, menu.size());
    }

    @Test
    public void testRemove() throws MenuException {
        Menu menu = new Menu();
        menu.add(new Item("a", "11.1", "aaa"));
        menu.add(new Item("b", "33.1", "bbb"));
        menu.add(new Item("c", "33.1", "bbb"));
        menu.remove(new Item("b", "33.1", "bbb"));
        assertEquals(2, menu.size());
    }

    @Test(expected = MenuException.class)
    public void testAddFailure() throws MenuException {
        Menu menu = new Menu();
        menu.add(new Item("b", "33.1", "bbb"));
        menu.add(new Item("b", "33.1", "bbb"));
    }

    @Test
    public void testUpdateItem() throws MenuException {
        Menu menu = new Menu();
        Item item1 = new Item("b", "33.1", "bbb");
        Item item2 = new Item("b", "33.4", "bbb");
        menu.add(new Item("b", "33.1", "bbb"));
        assertEquals(item1, menu.get().stream().findFirst().get());
        menu.update(item1, item2);
        assertEquals(1, menu.size());
        List<Item> items = menu.get();
        assertEquals(item2, items.stream().findFirst().get());
    }

}
