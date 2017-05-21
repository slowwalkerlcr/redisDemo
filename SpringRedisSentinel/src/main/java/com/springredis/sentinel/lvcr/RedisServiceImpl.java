package com.springredis.sentinel.lvcr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;



/**
 * Created by Administrator on 2017/5/21.
 */
//@Service("redisService")
public class RedisServiceImpl {

    @Autowired
    private RedisTemplate<?,?> redisTemplate;




    public void set(final String key, final String value) {
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection)
                    throws DataAccessException {
                System.out.println("=========================");
                connection.set(
                        redisTemplate.getStringSerializer().serialize(key),
                        redisTemplate.getStringSerializer().serialize(value));
                System.out.println("save key:" + key + ",value:" + value);
                return null;
            }
        });
    }




    public String get(final String key) {
        return redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection)
                    throws DataAccessException {
                byte[] byteKye = redisTemplate.getStringSerializer().serialize(
                        key);
                if (connection.exists(byteKye)) {
                    byte[] byteValue = connection.get(byteKye);
                    String value = redisTemplate.getStringSerializer()
                            .deserialize(byteValue);
                    System.out.println("get key:" + key + ",value:" + value);
                    return value;
                }
                System.out.println("valus does not exist!,key:"+key);
                return null;
            }
        });
    }


    public void delete(final String key) {
        redisTemplate.execute(new RedisCallback<Object>() {
            public Object doInRedis(RedisConnection connection) {
                connection.del(redisTemplate.getStringSerializer().serialize(
                        key));
                return null;
            }
        });
    }





}
