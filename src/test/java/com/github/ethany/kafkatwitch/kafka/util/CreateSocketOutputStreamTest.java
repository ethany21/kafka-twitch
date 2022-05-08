package com.github.ethany.kafkatwitch.kafka.util;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;


class CreateSocketOutputStreamTest {

    private static final Logger LOGGER = Logger.getLogger(CreateSocketOutputStreamTest.class.getName());


    @Test
    public void testCreateSocketOutputStream() throws IOException {

        /**
        SocketOutputStreamDto socketOutput = CreateSocketOutputStream.builder().logger(LOGGER).build().createSocketOutputStream();

        OutputStream outputStream = socketOutput.getOutputStream();
        outputStream.write(("JOIN " + "#rkdthdus930" + "\n").getBytes(StandardCharsets.UTF_8));
        String line;
        while ((line = new BufferedReader(new InputStreamReader(socketOutput.getSocket().getInputStream(), StandardCharsets.UTF_8)).readLine()) != null) {
            System.out.println(line);
        }
         */

    }

}