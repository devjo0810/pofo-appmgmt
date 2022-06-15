package com.pofo.appmgmt.configure;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import io.lettuce.core.ReadFrom;
import io.lettuce.core.cluster.ClusterClientOptions;
import io.lettuce.core.cluster.ClusterTopologyRefreshOptions;

@Configuration
public class RedisConfig {
	@Value("${spring.redis.host}")
	private String redisHost;
	
	@Value("${spring.redis.port}")
	private int redisPort;

	@Value("${spring.redis.password}")
	private String redisPassword;
	
	@Value("${spring.profile.active}")
	private String propActive;
	
	public RedisTemplate<String, ?> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate  = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(this.redisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}
	
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		if ("prd".equals(propActive)) {
			RedisClusterConfiguration clusterConf = new RedisClusterConfiguration();
			clusterConf.clusterNode(redisHost, redisPort);
			clusterConf.setPassword(redisPassword);
			
			ClusterTopologyRefreshOptions topologyRefreshOptions = 
					ClusterTopologyRefreshOptions.builder()
					.closeStaleConnections(true)
					.dynamicRefreshSources(true)
					.enableAdaptiveRefreshTrigger(ClusterTopologyRefreshOptions.RefreshTrigger.MOVED_REDIRECT, ClusterTopologyRefreshOptions.RefreshTrigger.PERSISTENT_RECONNECTS)
					.adaptiveRefreshTriggersTimeout(Duration.ofSeconds(5))
					.build();
			
			ClusterClientOptions clusterClientOptions = 
					ClusterClientOptions.builder()
					.autoReconnect(true)
					.topologyRefreshOptions(topologyRefreshOptions)
					.validateClusterNodeMembership(false)
					.build();
			
			LettuceClientConfiguration clientConfig = 
					LettuceClientConfiguration.builder()
					.readFrom(ReadFrom.SLAVE_PREFERRED)
					.clientOptions(clusterClientOptions)
					.commandTimeout(Duration.ofSeconds(5))
					.build();
			
			LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(clusterConf, clientConfig);
			lettuceConnectionFactory.afterPropertiesSet();
			return lettuceConnectionFactory;
		} else {
			RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisHost, redisPort);
			if ("dev".equals(propActive)) {
				redisStandaloneConfiguration.setPassword(redisPassword);
			}
			LettuceConnectionFactory lettuceConnectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);
			return lettuceConnectionFactory;
		}
	}
	
	
}
