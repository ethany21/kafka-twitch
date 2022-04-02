package com.github.ethany.kafkatwitch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;

class ConnectTwitchTest {

    @Test
    public void testConnection() throws IOException {

        ConnectTwitch connectTwitch = new ConnectTwitch();

        connectTwitch.connect();


    }

}