package com.example.zcqtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Resttemplateconfig {

    @Bean
    public RestTemplate restTemplate() {

        return new RestTemplate();
    }

    @Bean(name = "externalRestTemplate")
    public RestTemplate externalRestTemplate(){

        RestTemplate testTemplate = new RestTemplate();
        return testTemplate;
    }


}
