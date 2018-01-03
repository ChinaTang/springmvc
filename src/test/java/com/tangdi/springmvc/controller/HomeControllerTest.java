package com.tangdi.springmvc.controller;

import com.tangdi.springmvc.Spittle;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.web.servlet.view.InternalResourceView;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class HomeControllerTest {


    @Test
    public void testHomePage() throws Exception {
        HomeController controller = new HomeController();
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/")).andExpect(view().name("home"));
    }

    /*@Test
    public void shouldShowRecentSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(20);
        SpittleRepository repository = mock(SpittleRepository.class);
        when(repository.findSpittles(Long.MAX_VALUE, 20))
                .thenReturn(expectedSpittles);
        SpittleController controller = new SpittleController(repository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("")).build();
        mockMvc.perform(get("/spittles"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"));
    }*/
    private List<Spittle> createSpittleList(int count){
        List<Spittle> spittles = new ArrayList<Spittle>();
        for(int i = 0; i < count; i++){
            spittles.add(new Spittle("Spittle " + i, new Date(),
                    0.0, 0.0));
        }
        return spittles;
    }

    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittleList(50);
        SpittleRepository repository = mock(SpittleRepository.class);
        when(repository.findSpittles(238900, 50))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(repository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView(""))
                .build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList"
                        , hasItem(expectedSpittles.toArray())));
    }


}
