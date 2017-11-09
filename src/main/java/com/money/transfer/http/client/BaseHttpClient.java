package com.money.transfer.http.client;


import com.money.transfer.http.client.properties.Group;
import com.money.transfer.http.client.response.impl.GetAgentDetailsResponse;
import com.money.transfer.http.client.response.impl.GetSourceCountriesResponse;
import lombok.SneakyThrows;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;

public abstract class BaseHttpClient {

    public abstract GetAgentDetailsResponse getAgentDetails();

    public abstract GetSourceCountriesResponse getSourceCountries();

    abstract String getBaseUrl();

    abstract Group getGroup(String name);

    abstract String getProtocol();

    @SneakyThrows
    URI buildUri(String groupName, String methodName) {
        Group group = getGroup(groupName);
        Map<String, String> methods = group.getMethods();
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme(getProtocol())
                .host(getBaseUrl())
                .pathSegment(group.getName(), methods.get(methodName))
                .build();
        return uriComponents.toUri();
    }
}
