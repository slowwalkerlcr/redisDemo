package com.springredis.sentinel.lvcr;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/5/21.
 */
//@ContextConfiguration(locations="classpath*:spring-redis.xml")
public class RedisTest {

    /*@Resource(name="redisService")
    private RedisServiceImpl redisService;
*/

    private static ConfigurableApplicationContext context;

    RedisServiceImpl redisService;

  //  @Test
    public void testSave(){
        System.out.println("============");
        try{
            redisService.set("k1","v1");
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Test
    public void testSave1() {
        try{
            context = new ClassPathXmlApplicationContext(
                    "classpath*:spring-redis.xml");
            redisService = (RedisServiceImpl) context.getBean("redisService");

            redisService.set("k1","v1");
        }catch(Exception e){
            e.printStackTrace();
        }

    }

}











