package com.yanggy.es;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by yangguiyun on 2017/9/5.
 */

@SpringBootApplication
public class EsServer {
    public static void main(String[] args) {
        SpringApplication.run(EsServer.class, args);
    }
}
