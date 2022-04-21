package com.github.ethany.kafkatwitch.elasticsearch.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "twitch")
@Data
public class TwitchMessage {
    @Id
    private String id;

    private String streamer;

    private String viewer;

    private String message;

}
