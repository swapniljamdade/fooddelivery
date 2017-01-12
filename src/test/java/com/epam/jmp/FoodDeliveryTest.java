package com.epam.jmp;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Tomasz_Kozlowski on 1/12/2017.
 */
public class FoodDeliveryTest {

    private List<Restaurant> restaurants = Lists.newLinkedList();

    @Before
    public void setUp() {
        restaurants.add(new Restaurant(1, "Rest_1", Restaurant.Type.BRITISH, new Location(11,22), new Menu()));
        restaurants.add(new Restaurant(1, "Rest_2", Restaurant.Type.CHINESE, new Location(23,12), new Menu()));
        restaurants.add(new Restaurant(1, "Rest_3", Restaurant.Type.BRITISH, new Location(10,44), new Menu()));
        restaurants.add(new Restaurant(1, "Rest_4", Restaurant.Type.INDIAN, new Location(11,24), new Menu()));
        restaurants.add(new Restaurant(1, "Rest_5", Restaurant.Type.BRITISH, new Location(11,12), new Menu()));
    }

    @Test
    public void testRestFindForType() throws Exception {
        FoodDelivery fd = new FoodDelivery();
        fd.addBulk(restaurants);

        List<Restaurant> list = fd.findForType(Restaurant.Type.BRITISH);
        assertEquals(3, list.size());

        list = fd.findForType(Restaurant.Type.CHINESE);
        assertEquals(1, list.size());
        assertEquals("Rest_2", list.stream().findFirst().orElseThrow(()->new Exception("")).getName());

        list = fd.findForType(Restaurant.Type.INDIAN);
        assertEquals(1, list.size());
    }

}
