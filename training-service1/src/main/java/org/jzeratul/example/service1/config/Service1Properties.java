package org.jzeratul.example.service1.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@Data
@RefreshScope
@NoArgsConstructor
@ConfigurationProperties("funny")
public class Service1Properties {

  private String message;
}
