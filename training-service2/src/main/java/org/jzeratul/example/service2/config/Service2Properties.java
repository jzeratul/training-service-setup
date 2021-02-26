package org.jzeratul.example.service2.config;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("funny")
@Data
@NoArgsConstructor
public class Service2Properties {

  private String message;
}
