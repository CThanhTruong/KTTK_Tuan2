package Redis;

import gui.GUI_user2;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisSub {
	public static void subscriber() {
		try (Jedis sub = new Jedis()){
			sub.subscribe(new JedisPubSub() {
			
				@Override
				public void onMessage(String channel,String message) {
					GUI_user2.textarea.append(message);
					System.out.println(message);
				}
			}, "test" );
		}
	}
}
