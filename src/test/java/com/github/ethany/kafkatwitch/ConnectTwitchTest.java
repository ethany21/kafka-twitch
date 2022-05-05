package com.github.ethany.kafkatwitch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

class ConnectTwitchTest {

    @Test
    public void testPingCheck() {
        String str = "PING :tmi.twitch.tv";
        assert "PING".equals(str.split(" ")[0]);
    }

    @Test
    public void testStringSplit(){
        String str = "alpong1!dalpong1@dalpong1.tmi.twitch.tv PRIVMSG #lck_korea :왈맆에선 가렌이 좋아 ㅇㅈ? 성불한 가렌유저들 모두 손 들어주세요~~";
        System.out.println(str.split(" ")[2]);
    }

    @Test
    public void testTwitchSocketConnection() throws IOException{

        try (Socket socket = new Socket("irc.chat.twitch.tv", 6667)) {
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
            outputStream.write(("JOIN " + "#rkdthdus930" + "\n").getBytes(StandardCharsets.UTF_8));
            outputStream.write(("JOIN " + "#39daph" + "\n").getBytes(StandardCharsets.UTF_8));

            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            String line;
            BufferedWriter writer;

            while ((line = reader.readLine()) != null) {
                try {
                    if (line.split(" ")[0].equals("PING")) {
                        outputStream.write(("PONG\n").getBytes(StandardCharsets.UTF_8));
                    } else {
                        String key = line.split(" ")[2];
                        System.out.println(line);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("I caught exception " + e.getMessage());
                }
            }
        }

    }

}