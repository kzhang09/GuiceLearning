package redis;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.Arrays;
import java.util.Objects;

public class RedisClientProvider implements Provider<RedisDataSource>
{

	@Inject
	@Named("redis.database")
	private Integer database;
	@Inject
	@Named("redis.host")
	private String host;
	@Inject
	@Named("redis.port")
	private Integer port;
	@Inject
	@Named("redis.password")
	private String password;
	@Inject
	@Named("redis.pool.max.active")
	private Integer maxActive;
	@Inject
	@Named("redis.pool.max.idle")
	private Integer maxIdle;
	@Inject
	@Named("redis.pool.max.wait")
	private Integer maxWait;
	@Inject
	@Named("redis.pool.min.idle")
	private Integer minIdle;
	@Inject
	@Named("redis.timeout")
	private Integer timeout;



	private ShardedJedisPool getJedisPool() {
		if (Objects.isNull(shardedPool)) {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(this.maxActive);
			config.setMaxWaitMillis(this.maxWait);
			config.setMaxIdle(this.maxIdle);
			config.setMinIdle(this.minIdle);

			JedisShardInfo info = new JedisShardInfo(this.host, this.port.intValue(),
					this.timeout.intValue());
			if (this.password != null && !this.password.isEmpty()) {
				info.setPassword(password);
			}
			shardedPool = new ShardedJedisPool(config, Arrays.asList(new JedisShardInfo[]{info}));
		} else {
			return shardedPool;
		}
		return shardedPool;
	}

	@Override
	public RedisDataSource get() {
		return new RedisDataSource(getJedisPool());
	}


	private static ShardedJedisPool shardedPool;


}
