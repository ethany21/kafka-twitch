package com.github.ethany.kafkatwitch.kafka.util;

import lombok.*;

import java.io.OutputStream;
import java.net.Socket;


@Builder
@Data
public class SocketOutputStreamDto {
    private Socket socket;
    private OutputStream outputStream;
}
