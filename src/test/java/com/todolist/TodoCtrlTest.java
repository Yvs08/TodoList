package com.todolist;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todolist.domain.Todo;
import com.todolist.repository.TodoRepository;
import java.io.IOException;
import java.util.Date;
import org.mockito.Mock;
import org.json.JSONObject;
import org.json.JSONArray;
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
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class TodoCtrlTest {

    private MockMvc mockMvc;
    private Todo todo1;

    @Autowired
    private WebApplicationContext context;

    @Mock
    private TodoRepository todoRepository;

    @Before
    public void setUp() {
        initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
        todo1 = new Todo("3", "Title", "descripte");
    }

    protected String mapToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);

    }

    protected <T> T mapFromJson(String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, clazz);
    }

    @Test
    public void shouldBeAbleToSaveAList() {
        todoRepository.save(todo1);
        verify(todoRepository).save(todo1);
    }

    @Test
    public void checkedIfTheObjectsThatAreContainedInTheDatabaseCorrespondsToThoseOfUrl() throws Exception {

        MvcResult result = mockMvc.perform(get("/todo"))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();

        JSONArray array = new JSONArray(content);

        for (int i = 0; i < array.length(); ++i) {
            JSONObject obj = array.getJSONObject(i);

            System.out.println(obj.getString("number"));
        }
    }

    @Test
    public void test1() throws Exception {
        this.mockMvc.perform(get("/voir"))
                .andExpect(status().isOk())
                .andExpect(content().string("Salut"));
    }

    @Test
    public void checkedIfAllObjectsHaveValidatedAllEqualStatesHasDone() throws Exception {
        String number = "1";
        String url = "/validate/";

        MvcResult result = mockMvc.perform(get(url + number))
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();

        @SuppressWarnings("UnusedAssignment")
        Todo todo = new Todo();
        todo = mapFromJson(content, Todo.class);

        Assert.assertNotNull(todo);
        Assert.assertEquals("failure- expected todo.numero match", "done", todo.getState());

    }

    @After
    public void teardown() {
        this.mockMvc = null;
    }

}
