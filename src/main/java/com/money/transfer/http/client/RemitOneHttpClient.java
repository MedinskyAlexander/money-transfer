package com.money.transfer.http.client;

import com.money.transfer.http.client.properties.Credentials;
import com.money.transfer.http.client.properties.Group;
import com.money.transfer.http.client.properties.HttpClientProperties;
import com.money.transfer.http.client.request.BaseHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class RemitOneHttpClient extends HttpClient {


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpClientProperties properties;


    public String getAgentDetails() {
        String url = buildUrl("agent", "get-details");
        Credentials credentials = properties.getCredentials();
        BaseHttpRequest httpRequest = BaseHttpRequest.builder().credentials(credentials).build();
        HttpEntity<BaseHttpRequest> request = new HttpEntity<>(httpRequest);
        return restTemplate.postForObject(url, request, String.class);
    }

    @Override
    public String getSourceCountries() {
        String url = buildUrl("admin", "get-source-countries");
        Credentials credentials = properties.getCredentials();
        BaseHttpRequest httpRequest = BaseHttpRequest.builder().credentials(credentials).build();
        HttpEntity<BaseHttpRequest> request = new HttpEntity<>(httpRequest);

        return restTemplate.postForObject(url, request, String.class);
    }

    @Override
    String getBaseUrl() {
        return properties.getBaseUrl();
    }

    @Override
    Group getGroup(String name) {
        return properties.getGroupByName(name);
    }


}
