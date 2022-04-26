package com.github.ethany.kafkatwitch;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class KafkaTwitchApplicationTests {
	@Test
	public void testConnection() {

		assert true;


	}

	@Test
	public void testStringSplit(){
		String str = ":coolstone1010!coolstone1010@coolstone1010.tmi.twitch.tv PRIVMSG #woowakgood :���� �Ĺ��� �����ϳ�";
		System.out.println(str);
		System.out.println(str.split(".tmi.twitch.tv PRIVMSG ")[0].split("@")[1]);
		System.out.println(str.split(".tmi.twitch.tv PRIVMSG ")[1].split(" :", 2)[0]);
		System.out.println(str.split(".tmi.twitch.tv PRIVMSG ")[1].split(" :", 2)[1]);
	}
}
