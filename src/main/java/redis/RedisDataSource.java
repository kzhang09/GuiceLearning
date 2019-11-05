package redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisDataSource
{

	private static final Logger log = LoggerFactory.getLogger(RedisDataSource.class);

	private ShardedJedisPool shardedJedisPool;

	public RedisDataSource(ShardedJedisPool jedisPool)
	{
		this.shardedJedisPool = jedisPool;
	}



	public ShardedJedis getRedisClient() {
		try {
			ShardedJedis shardJedis = shardedJedisPool.getResource();
			return shardJedis;
		} catch (Exception e) {
			log.error("getRedisClent error", e);
		}
		return null;
	}

	public void returnResource(ShardedJedis shardedJedis) {
		shardedJedis.close();
	}

}
