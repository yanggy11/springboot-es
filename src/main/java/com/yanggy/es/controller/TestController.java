package com.yanggy.es.controller;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by derrick.yang on 9/7/17.
 */

@RestController
public class TestController {

    @Resource
    private TransportClient client;
    @RequestMapping(value = "test", method = RequestMethod.POST)
    public Object test() {
        GetResponse getResponse = client.prepareGet("posts","post","1").execute().actionGet();

        return getResponse;
    }
}
