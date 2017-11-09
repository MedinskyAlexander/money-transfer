package com.money.transfer.http.client;


import com.money.transfer.http.client.properties.Group;
import com.money.transfer.http.client.properties.HttpClientProperties;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public abstract class BaseHttpClient {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpClientProperties properties;

    @SneakyThrows
    URI buildUri(String groupName, String methodName) {
        Group group = properties.getGroupByName(groupName);
        Map<String, String> methods = group.getMethods();
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(properties.getProtocol())
                .host(properties.getBaseUri())
                .pathSegment(group.getName(), methods.get(methodName))
                .build();
        return uriComponents.toUri();
    }
}
