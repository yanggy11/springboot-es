package com.yanggy.es;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by yangguiyun on 2017/9/5.
 */

@SpringBootApplication
public class EsServer {
    public static void main(String[] args) {
        //设置集群名称
        Settings settings = Settings.builder().put("cluster.name", "yanggy").build();
        //创建client
        TransportClient client = null;
        try {
            client = new PreBuiltTransportClient(settings)
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //搜索数据
        GetResponse response = client.prepareGet("posts", "post", "1").execute().actionGet();
        //输出结果
        System.out.println(response.getSourceAsString());
        //关闭client
        client.close();
//        SpringApplication.run(EsServer.class, args);
    }
}
