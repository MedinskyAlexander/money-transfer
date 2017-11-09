package com.money.transfer.http.client;

import com.money.transfer.http.client.properties.Credentials;
import com.money.transfer.http.client.response.impl.GetSourceCountriesResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URI;

@Component
public class AdminRemitOneHttpClientImpl extends BaseHttpClient implements AdminRemitOneHttpClient {

    public GetSourceCountriesResponse getSourceCountries() {
        URI uri = buildUri("admin", "get-source-countries");
        Credentials credentials = properties.getGroupByName("admin").getCredentials();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("username", credentials.getUsername());
        params.add("password", credentials.getPassword());
        params.add("pin", credentials.getPin());

        HttpEntity request = new HttpEntity<>(params, headers);
        return restTemplate.postForObject(uri, request, GetSourceCountriesResponse.class);
    }


}
