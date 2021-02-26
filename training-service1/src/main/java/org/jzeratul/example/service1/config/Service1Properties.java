package org.jzeratul.example.service1.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("funny")
@Data
@NoArgsConstructor
public class Service1Properties {

  private String message;
}
