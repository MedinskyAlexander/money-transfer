package com.money.transfer.http.client;


import com.money.transfer.http.client.properties.Group;
import com.money.transfer.http.client.response.impl.GetAgentDetailsResponse;
import com.money.transfer.http.client.response.impl.GetSourceCountriesResponse;
import lombok.SneakyThrows;

public abstract class HttpClient {

    private static final String SLASH = "/";

    public abstract GetAgentDetailsResponse getAgentDetails();

    public abstract GetSourceCountriesResponse getSourceCountries();

    abstract String getBaseUrl();

    abstract Group getGroup(String name);

    @SneakyThrows
    String buildUrl(String groupName, String methodName) {

        StringBuilder result = new StringBuilder(addSlashToTheEndIfNotExist(getBaseUrl()));
        result.append(addSlashToTheEndIfNotExist(groupName));

        Group group = getGroup(groupName);
        String method = group.getMethods().get(methodName);
        result.append(method);

        return result.toString();
    }

    private String addSlashToTheEndIfNotExist(String string) {
        return string.endsWith(SLASH) ? string : string + SLASH;
    }

}
