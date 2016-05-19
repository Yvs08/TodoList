package com.todolist;

import com.mongodb.util.JSON;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.junit.Assert;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class TodoCtrlTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    // private TodoRepository  todoServiceMock;
    @Before
    public void setUp() {

        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    public void test() throws Exception {
        String ecran = "{\"numero\":\"1\",\"titre\":\"a\",\"dateDeCréation\":1463567017282,\"desccription\":\"z\",\"dateDeCheance\":1463567017282,\"etat\":\"todo\"}";
        //   MvcResult result = mockMvc.perform(get("/todo"))
        this.mockMvc.perform(get("/todo"))
                .andExpect(status().isOk())
                .andExpect(content().string(ecran));
        // .andExpect(forwardedUrl("http://localhost:8080/todo"))
        //  .andReturn();//.andExpect(content().json("{'numero':'1','titre':'a','dateDeCréation':'1463567017282','desccription':'z','dateDeCheance':'1463567017282','etat':'todo'}"));
        // String output = "salu";
        // String ecran = "{\"numero\":\"1\",\"titre\":\"a\",\"dateDeCréation\":1463567017282,\"desccription\":\"z\",\"dateDeCheance\":1463567017282,\"etat\":\"todo\"}";
        //String content = result.getResponse().getContentAsString();
        //Object json = JSON.parse(content);
        //JSONObject jObject  = new JSONObject(json);
        //String jsonText = jObject.toString();
        //  Assert.assertTrue(content.equals(jsonText));

    }

    @Test
    public void test1() throws Exception {
        this.mockMvc.perform(get("/voir"))
                .andExpect(status().isOk())
                .andExpect(content().string("Salut"));
    }

    @After
    public void teardown() {
        this.mockMvc = null;
    }

}