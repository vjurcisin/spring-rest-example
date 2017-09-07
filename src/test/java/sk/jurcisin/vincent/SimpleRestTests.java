package sk.jurcisin.vincent;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sk.jurcisin.vincent.controller.GreetingController;

/**
 * Created by vincent on 6.9.2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class SimpleRestTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGreetingRest() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/greeting?name=Vincent")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":1,\"content\":\"Hello, Vincent!\"}";
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }
}
