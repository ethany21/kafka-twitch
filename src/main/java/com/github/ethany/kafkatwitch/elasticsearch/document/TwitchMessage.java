package com.github.ethany.kafkatwitch.elasticsearch.document;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = "twitch")
@Data
@Builder
@Setting(settingPath = "static/es-settings.json")
public class TwitchMessage {
    @Id
    @Field(type = FieldType.Keyword)
    private String id;

    @Field(type = FieldType.Text)
    private String streamer;

    @Field(type = FieldType.Text)
    private String viewer;

    @Field(type = FieldType.Text)
    private String message;

}
