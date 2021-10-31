package com.example.selenium.core;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties
@EnableConfigurationProperties
public class SpringPropertiesConfiguration {

    @Value("${host}")
    private String host;

    @Value("${browser}")
    private String browser;
}
