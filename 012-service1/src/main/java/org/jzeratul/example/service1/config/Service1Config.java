package org.jzeratul.example.service1.config;

import org.jzeratul.example.service2.client.api.Service2DataApiClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({Service1Properties.class})
@Configuration
@EnableFeignClients(clients = {Service2DataApiClient.class})
public class Service1Config {

}