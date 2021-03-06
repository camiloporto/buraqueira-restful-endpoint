package br.com.camiloporto.buraqueira.endpoint.rest;

import br.com.camiloporto.buraqueira.BuraqueiraRestfulEndpointApplication;
import br.com.camiloporto.buraqueira.endpoint.model.AccelerometerData;
import br.com.camiloporto.buraqueira.endpoint.model.Id;
import br.com.camiloporto.buraqueira.endpoint.repository.AccelerometerDataRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by camiloporto on 10/04/16.
 */


@SpringApplicationConfiguration(classes = BuraqueiraRestfulEndpointApplication.class)
@WebAppConfiguration
public class BuraqueiraRestTest extends AbstractTestNGSpringContextTests {

    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private AccelerometerDataRepository dataRepository;

    private static final String sender = "sender@email.com";

    @BeforeClass
    public void setUp() throws Exception {
        mvc =  webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void shouldReceiveRawAccelerometerData() throws Exception {
        long time = System.currentTimeMillis();
        AccelerometerData d = new AccelerometerData(sender, 4.0, 3.0, 7.0, time);
        String jsonContent = toJson(d);

        mvc.perform(MockMvcRequestBuilders
                .post("/")
                .content(jsonContent)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());


        AccelerometerData generatedId = dataRepository.findOne(new Id(sender, time));
        Assert.assertNotNull(generatedId);

        //FIXME make this test pass

    }

    private String toJson(AccelerometerData p) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(p);
    }
}
