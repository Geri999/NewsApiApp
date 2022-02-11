package com.example.newsapiapp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class NewsApiAppApplicationTests {

    @Value("${api-key}")
    private String apiKey;

    @Test
    void contextLoads() {
        Assertions.assertEquals("531566c5630c4a8a85cd5d8ca15ac3a8", apiKey);
    }
}
