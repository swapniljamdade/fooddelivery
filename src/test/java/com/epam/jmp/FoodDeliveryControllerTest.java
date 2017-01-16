package com.epam.jmp;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fooddelivery.gateway.MenuAmendment;
import com.fooddelivery.gateway.RestaurantSearch;
import com.fooddelivery.model.Restaurant;
import com.fooddelivery.web.FoodDeliveryController;
import com.google.gson.Gson;

public class FoodDeliveryControllerTest {
	
	private MediaType contentType = new MediaType("application", "json", Charset.forName("UTF-8"));
	
	private MockMvc mockMvc;

    @Mock
	private RestaurantSearch restaurantSearchGateway;

    @InjectMocks
    private FoodDeliveryController foodDeliveryController;
    
    @Mock
    private MenuAmendment menuAmendmentGateway;
    
    private Gson gson = new Gson();
    
    @Before
    public void init(){
    	
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(foodDeliveryController).build();
    }
    
    @Test
    public void shouldReturnListOfRestaurantsWhenGetRestaurantListIsCalled() throws Exception {
    	
        when(restaurantSearchGateway.findForType(Restaurant.Type.ITALIAN)).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/restaurants/{type}", Restaurant.Type.ITALIAN))
        		 .andExpect(status().isOk());

        verify(restaurantSearchGateway, times(1)).findForType(Restaurant.Type.ITALIAN);
        verifyNoMoreInteractions(restaurantSearchGateway);
    }
    
    
    @Test
    public void shouldAddRestauarant() throws Exception {
        doNothing().when(restaurantSearchGateway).addRestaurant(null);

        this.mockMvc.perform(post("/addRestaurant").contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(gson.toJson(null)))
        		.andExpect(status().isOk());

        verify(restaurantSearchGateway, times(1)).addRestaurant(null);
        verifyNoMoreInteractions(restaurantSearchGateway);
    }

}
