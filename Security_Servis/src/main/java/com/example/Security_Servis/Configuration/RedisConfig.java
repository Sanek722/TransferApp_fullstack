package com.example.Security_Servis.Configuration;

import com.example.Security_Servis.Model.Userdata;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig
{
    @Bean
    public RedisTemplate<String, Userdata> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Userdata> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);

        // Используйте Jackson2JsonRedisSerializer для сериализации объектов в JSON
        template.setDefaultSerializer(new Jackson2JsonRedisSerializer<>(Userdata.class));

        // Сериализация ключей как строки
        template.setKeySerializer(new StringRedisSerializer());

        // Сериализация хранимых объектов как строки
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(Userdata.class));

        return template;
    }
}
