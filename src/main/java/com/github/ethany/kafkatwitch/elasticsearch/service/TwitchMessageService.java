package com.github.ethany.kafkatwitch.elasticsearch.service;

import com.github.ethany.kafkatwitch.elasticsearch.document.TwitchMessage;
import com.github.ethany.kafkatwitch.elasticsearch.repository.TwitchMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TwitchMessageService {

    private final TwitchMessageRepository twitchMessageRepository;

    public void save(final TwitchMessage twitchMessage) {
        twitchMessageRepository.save(twitchMessage);
    }
}

