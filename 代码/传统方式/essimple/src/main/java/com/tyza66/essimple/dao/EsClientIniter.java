package com.tyza66.essimple.dao;


import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;

public class EsClientIniter {

    public static ElasticsearchClient getClient() {
        // 创建低级别客户端
        RestClient restClient = RestClient.builder(
                        new HttpHost("192.168.72.128", 9200, "http")) // 使用 http 协议
                .build();

        // 使用 Jackson 映射器创建传输客户端
        ElasticsearchTransport transport = new RestClientTransport(
                restClient, new JacksonJsonpMapper());

        return new ElasticsearchClient(transport);
    }
}
