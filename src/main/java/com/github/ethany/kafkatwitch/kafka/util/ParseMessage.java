package com.github.ethany.kafkatwitch.kafka.util;

public class ParseMessage {

    public static String getViewer(String message) {
        return message.split(".tmi.twitch.tv PRIVMSG ")[0].split("@")[1];
    }

    public static String getStreamer(String message) {
        return message.split(".tmi.twitch.tv PRIVMSG ")[1].split(" :", 2)[0];
    }

    public static String getMessage(String message) {
        return message.split(".tmi.twitch.tv PRIVMSG ")[1].split(" :", 2)[1];
    }

}
