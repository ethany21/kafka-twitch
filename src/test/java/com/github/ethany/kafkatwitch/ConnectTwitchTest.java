package com.github.ethany.kafkatwitch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

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

}