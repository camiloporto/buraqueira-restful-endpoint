package br.com.camiloporto.buraqueira.endpoint.rest;

import br.com.camiloporto.buraqueira.BuraqueiraRestfulEndpointApplication;
import br.com.camiloporto.buraqueira.endpoint.model.AccelerometerData;
import br.com.camiloporto.buraqueira.endpoint.model.Id;
import br.com.camiloporto.buraqueira.endpoint.model.Location;
import br.com.camiloporto.buraqueira.endpoint.repository.AccelerometerDataRepository;
import br.com.camiloporto.buraqueira.endpoint.repository.LocationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.DBCollection;
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

import java.math.BigDecimal;
import java.util.Arrays;

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

    @Autowired
    private LocationRepository locationRepository;

    @BeforeClass
    public void setUp() throws Exception {
        mvc =  webAppContextSetup(webApplicationContext)
                .build();
    }

    @Test
    public void shouldReceiveRawAccelerometerData() throws Exception {
        long time = System.currentTimeMillis();
        AccelerometerData d = new AccelerometerData(sender, 4.01, 3.02, 7.03, time);
        String jsonContent = toJson(d);

        mvc.perform(MockMvcRequestBuilders
                .post("/vibration")
                .content(jsonContent)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());


        AccelerometerData generatedId = dataRepository.findOne(new Id(sender, time));
        Assert.assertNotNull(generatedId);

    }

    @Test
    public void shouldReceiveRawAccelerometerDataInBatch() throws Exception {
        long time = System.currentTimeMillis();
        long time2 = time + 15323;
        AccelerometerData d = new AccelerometerData(sender, 4.01, 3.02, 7.03, time);
        AccelerometerData d2 = new AccelerometerData(sender, 7.03, 5.021, 7.056, time2);
        String jsonContent = toJson(Arrays.asList(d, d2));

        mvc.perform(MockMvcRequestBuilders
                .post("/vibrationBatch")
                .content(jsonContent)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());


        AccelerometerData generatedId = dataRepository.findOne(new Id(sender, time));
        Assert.assertNotNull(generatedId);

        generatedId = dataRepository.findOne(new Id(sender, time2));
        Assert.assertNotNull(generatedId);

    }

    @Test
    public void shouldReceiveLocationData() throws Exception {
        long time = System.currentTimeMillis();
        Location location = new Location(sender, time, BigDecimal.valueOf(-12.4567), BigDecimal.valueOf(32.45678));
        String jsonContent = toJson(location);

        mvc.perform(MockMvcRequestBuilders
                .post("/location")
                .content(jsonContent)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk());


        ;
        Location generatedId = locationRepository.findOne(new Id(sender, time));
        Assert.assertNotNull(generatedId);


    }

    private String toJson(Object p) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(p);
    }
}
