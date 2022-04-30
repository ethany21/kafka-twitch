package com.github.ethany.kafkatwitch.elasticsearch.configuration;

import com.github.ethany.kafkatwitch.elasticsearch.repository.TwitchMessageRepository;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackageClasses = TwitchMessageRepository.class)
public class ElasticsearchConfiguration {

    @Value("${spring.elasticsearch.hosts}")
    private String elasticsearchUrl;

    @Bean
    public RestHighLevelClient elasticsearchClient() {

        return new RestHighLevelClient(RestClient.builder(new HttpHost(elasticsearchUrl, 9200, "http")));
    }

}
