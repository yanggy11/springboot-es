package com.yanggy.es.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yanggy.es.model.User;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by derrick.yang on 9/12/17.
 */

@RestController
public class UserController {

    @Resource
    private TransportClient client;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Object insertUser(@RequestBody User user) {
        IndexResponse indexResponse = null;
        try {
            String json = new ObjectMapper().writeValueAsString(user);
            indexResponse = client.prepareIndex("users","users").setSource(json).execute().actionGet();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return indexResponse;
    }
}
