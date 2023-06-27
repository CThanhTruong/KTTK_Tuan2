package Redis;

import redis.clients.jedis.Jedis;

public class RedisPub {
	public static void publisher(String msg) {
		try (Jedis pub = new Jedis()){
			pub.publish("test", msg);
		}
	}
}
