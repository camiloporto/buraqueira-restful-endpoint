package br.com.camiloporto.buraqueira.endpoint.rest;

import br.com.camiloporto.buraqueira.endpoint.model.AccelerometerData;
import br.com.camiloporto.buraqueira.endpoint.repository.AccelerometerDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by camiloporto on 10/04/16.
 */
@RestController
public class AccelerometerRest {

    @Autowired
    private AccelerometerDataRepository repository;

    @RequestMapping(
            value = "/vibration",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void receiveAccelerometerData(@RequestBody AccelerometerData data) {

        System.out.println(data);

        repository.save(data);
    }

    @RequestMapping(
            value = "/location",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void receiveLocationData(@RequestBody Map<String, Object> data) {

        System.out.println(data);

    }
}
