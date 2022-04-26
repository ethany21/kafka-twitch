package com.github.ethany.kafkatwitch.kafka;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

@Component
@RequiredArgsConstructor
class Producer {

    private static final String TOPIC = "twitch";
    private static final Logger LOGGER = Logger.getLogger(Producer.class.getName());

    @Autowired
    private KafkaTemplate<String ,String> kafkaTemplate;

    @EventListener(ApplicationStartedEvent.class)
    public void sendMessage () throws IOException {

        Socket socket = new Socket("irc.chat.twitch.tv", 6667);

        OutputStream outputStream = socket.getOutputStream();

        outputStream.write(("PASS " + "oauth:kpz9iq7hk78g6ck8bycx5r3clg9vf9" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("NICK " + "davi21xxi" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#ddahyoni" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#kimdoe" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#sonycast_" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#lck_korea" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#amouranth" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#magenta62" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#sooflower" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#jungtaejune" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#zilioner" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#hanryang1125" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#woowakgood" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#obm1025" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#jingburger" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#dkwl025" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#rudbeckia7" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#nokduro" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#rooftopcat99" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#dda_ju" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#berry0314" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#woohankyung" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#nanajam777" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#shroud" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#johnny3047258" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#saddummy" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#dogswellfish" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#ch1ckenkun" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#sapnapalt" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#fextralife" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#veibae" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#pjs9073" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#pacific8815" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#2chamcham2" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#yumyumyu77" + "\n").getBytes(StandardCharsets.UTF_8));
        outputStream.write(("JOIN " + "#handongsuk" + "\n").getBytes(StandardCharsets.UTF_8));

        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

        String line;

        while ((line = reader.readLine()) != null) {

            try {
                if (line.split(" ")[0].equals("PING")){
                    outputStream.write(("PONG\n").getBytes(StandardCharsets.UTF_8));
                }
                else {
                    String key = line.split(" ")[2];
                    this.kafkaTemplate.send(TOPIC, key, line);
                }
            }
            catch (ArrayIndexOutOfBoundsException e){
                LOGGER.info("I caught exception " + e.getMessage());
            }
        }
    }


}
