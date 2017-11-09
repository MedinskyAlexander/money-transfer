package com.money.transfer.http.client;

import com.money.transfer.http.client.properties.Credentials;
import com.money.transfer.http.client.properties.Group;
import com.money.transfer.http.client.properties.HttpClientProperties;
import com.money.transfer.http.client.response.impl.GetAgentDetailsResponse;
import com.money.transfer.http.client.response.impl.GetSourceCountriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


@Component
public class RemitOneHttpClient extends HttpClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HttpClientProperties properties;


    public GetAgentDetailsResponse getAgentDetails() {
        String url = buildUrl("agent", "get-details");
        Credentials credentials = properties.getGroupByName("agent").getCredentials();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", credentials.getUsername());
        params.add("password", credentials.getPassword());
        params.add("pin", credentials.getPin());

        HttpEntity request = new HttpEntity<>(params, headers);
        return restTemplate.postForObject(url, request, GetAgentDetailsResponse.class);
    }

    @Override
    public GetSourceCountriesResponse getSourceCountries() {
        String url = buildUrl("admin", "get-source-countries");
        Credentials credentials = properties.getGroupByName("admin").getCredentials();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", credentials.getUsername());
        params.add("password", credentials.getPassword());
        params.add("pin", credentials.getPin());

        HttpEntity request = new HttpEntity<>(params, headers);
        return restTemplate.postForObject(url, request, GetSourceCountriesResponse.class);
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
