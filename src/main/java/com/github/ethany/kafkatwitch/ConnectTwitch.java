package com.github.ethany.kafkatwitch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

public class ConnectTwitch {

    private static final Logger LOGGER = Logger.getLogger(ConnectTwitch.class.getName());

    public void connect() throws IOException {

        Socket socket = new Socket("irc.chat.twitch.tv", 6667);

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(("PASS " + "oauth:kpz9iq7hk78g6ck8bycx5r3clg9vf9" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("NICK " + "davi21xxi" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#pacific8815" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#kimdoe" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#naseongkim" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#lck_korea" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#pjs9073" + "\n").getBytes(StandardCharsets.UTF_8));

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        String line;

        while ((line = reader.readLine()) != null) {
            LOGGER.info(line);
        }

    }
}
