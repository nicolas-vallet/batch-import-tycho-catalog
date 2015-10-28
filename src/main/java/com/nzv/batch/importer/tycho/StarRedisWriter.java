package com.nzv.batch.importer.tycho;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class StarRedisWriter implements ItemWriter<Star>{
	
	private RedisTemplate<String, Star> redisTemplate;

	@Override
	public void write(List<? extends Star> items) throws Exception {
		for (Star star : items) {
			// Do something with redisTemplate...
		}
	}

	public void setRedisTemplate(RedisTemplate<String, Star> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}
}
