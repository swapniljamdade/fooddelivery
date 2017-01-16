package com.menu.test;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

import com.google.gson.Gson;
import com.menu.model.Item;
import com.menu.model.Menu;
import com.menu.web.MenuController;

public class MenuControllerTest {
	
	private MediaType contentType = new MediaType("application", "json", Charset.forName("UTF-8"));
	
	private MockMvc mockMvc;

    @InjectMocks
    private MenuController menuController;
    
    @Mock
    private Menu menu;
    
    private Gson gson = new Gson();
    
    @Before
    public void init(){
    	
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(menuController).build();
    }
    
    @Test
    public void shouldGetListOfMenuItems() throws Exception {
    	
        when(menu.get()).thenReturn(new ArrayList<>());

        mockMvc.perform(get("/menu"))
        		 .andExpect(status().isOk());

        verify(menu, times(1)).get();
        verifyNoMoreInteractions(menu);
    }
    
    @Test
    public void shouldAddMenuItem() throws Exception {
        doNothing().when(menu).add(null);

        this.mockMvc.perform(post("/addMenuItem").contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(gson.toJson(null)))
        		.andExpect(status().isOk());

        verify(menu, times(1)).add(null);
        verifyNoMoreInteractions(menu);
    }
    
    @Test
    public void shouldUpdateMenuItem() throws Exception {
    	Item prevItem = new Item("Name", "10", "Name");
    	Item curr = new Item("Name1", "10", "Name1");
    	
        doNothing().when(menu).update(prevItem, curr);

        this.mockMvc.perform(put("/updateMenuItem").contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(gson.toJson(prevItem)))
        		.andExpect(status().isOk());

        verifyNoMoreInteractions(menu);
    }
    
    @Test
    public void shouldRemoveMenuItem() throws Exception {
    	Item item = new Item("Name1", "10", "Name1");
        doNothing().when(menu).remove(item);

        this.mockMvc.perform(put("/removeMenuItem").contentType(MediaType.APPLICATION_JSON_VALUE)
        		.content(gson.toJson(item)))
        		.andExpect(status().isOk());

        verifyNoMoreInteractions(menu);
    }
    
}
