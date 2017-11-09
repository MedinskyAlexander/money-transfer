package com.money.transfer.http.client;

import com.money.transfer.http.client.properties.Credentials;
import com.money.transfer.http.client.response.impl.GetAgentDetailsResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

@Component
public class AgentRemitOneHttpClientImpl extends BaseHttpClient implements AgentRemitOneHttpClient {

    public GetAgentDetailsResponse getAgentDetails() {
        URI uri = buildUri("agent", "get-details");
        Credentials credentials = properties.getGroupByName("agent").getCredentials();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", credentials.getUsername());
        params.add("password", credentials.getPassword());
        params.add("pin", credentials.getPin());

        HttpEntity request = new HttpEntity<>(params, headers);
        return restTemplate.postForObject(uri, request, GetAgentDetailsResponse.class);
    }


}
