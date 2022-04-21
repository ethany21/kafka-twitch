package com.github.ethany.kafkatwitch.elasticsearch.repository;

import com.github.ethany.kafkatwitch.elasticsearch.document.TwitchMessage;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TwitchMessageRepository extends ElasticsearchRepository<TwitchMessage, String> {
}
