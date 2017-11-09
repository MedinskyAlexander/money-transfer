package com.money.transfer.http.client.properties;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@PropertySource("classpath:http.client.properties")
@ConfigurationProperties()
@Data
@ToString
public class Group {
    private String name;
    private Map<String, String> methods;
    private Credentials credentials;

}


