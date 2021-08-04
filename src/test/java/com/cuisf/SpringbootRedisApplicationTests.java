package com.cuisf;

import com.cuisf.pojo.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class SpringbootRedisApplicationTests {


    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        /*
        * 获取连接
        * */
       /* RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
          connection.flushDb();
          connection.flushAll();*/

        //类似操作字符串
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("mykey","cuisf");
        System.out.println(redisTemplate.opsForValue().get("mykey"));


    }


    @Test
    public void test1() throws JsonProcessingException {

        User user = new User("cuisf", 16);

        //json字符串对象
        String jsonString = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",jsonString);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }

}
