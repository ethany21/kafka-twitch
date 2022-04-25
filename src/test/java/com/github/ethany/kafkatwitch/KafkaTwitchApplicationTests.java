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
		String str = "dalpong1!dalpong1@dalpong1.tmi.twitch.tv PRIVMSG #lck_korea :왈맆에선 가렌이 좋아 ㅇㅈ? 성불한 가렌유저들 모두 손 들어주세요~~";
		System.out.println(str);
		System.out.println(str.split(".tmi.twitch.tv PRIVMSG ")[0].split("@")[1]);
		System.out.println(str.split(".tmi.twitch.tv PRIVMSG ")[1].split(" :", 2)[0]);
		System.out.println(str.split(".tmi.twitch.tv PRIVMSG ")[1].split(" :", 2)[1]);
	}
}
