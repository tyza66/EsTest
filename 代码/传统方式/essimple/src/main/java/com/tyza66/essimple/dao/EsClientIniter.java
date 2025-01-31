package com.tyza66.essimple.dao;

import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.RestHighLevelClientBuilder;

public class EsClientIniter {

    public static RestHighLevelClient getClient(){
        RestClientBuilder builder = RestClient.builder(
                // 这里写死了本地的ES地址，实际应用中应该从配置文件中读取
                new HttpHost("192.168.72.128", 9200, "http"));
        // 设置为兼容模式
        RestHighLevelClientBuilder restHighLevelClientBuilder = new RestHighLevelClientBuilder(builder.build());
        RestHighLevelClient client = restHighLevelClientBuilder.build();
        return client;
    }
}
