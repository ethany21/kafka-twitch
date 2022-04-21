package com.github.ethany.kafkatwitch.elasticsearch.repository;

import com.github.ethany.kafkatwitch.elasticsearch.Document.TwitchMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TwitchMessageRepository extends ElasticsearchRepository<TwitchMessage, String> {
}
