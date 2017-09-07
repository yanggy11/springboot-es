package com.yanggy.es.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by derrick.yang on 9/7/17.
 */

@Component
public class EsConfiguration {

    @Value("${elasticsearch.clustername}")
    private String clustername;
    @Value("${elasticsearch.host}")
    private String host;
    @Value("${elasticsearch.port}")
    private String port;


    @Bean
    public TransportClient getClient() {
        //设置集群名称
        Settings settings = Settings.builder().put("cluster.name", clustername).build();
        //创建client
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(host), Integer.parseInt(port)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        return client;
    }
}
