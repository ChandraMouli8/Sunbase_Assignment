package com.example.ragchatbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.zilliz.client.ZillizClient;

@Configuration
public class AppConfig {

    @Bean
    public ZillizClient zillizClient() {
        return new ZillizClient();
    }
}
