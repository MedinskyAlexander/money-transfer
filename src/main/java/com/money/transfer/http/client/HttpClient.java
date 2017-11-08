package com.money.transfer.http.client;


import com.money.transfer.http.client.properties.Group;

public abstract class HttpClient {

    private static final String SLASH = "/";

    public abstract String getAgentDetails();

    public abstract String getSourceCountries();

    abstract String getBaseUrl();

    abstract Group getGroup(String name);


    String buildUrl(String groupName, String methodName) {
        StringBuilder result = new StringBuilder(addSlashToTheEndIfNotExist(getBaseUrl()));
        result.append(addSlashToTheEndIfNotExist(groupName));

        Group group = getGroup(groupName);
        String method = group.getMethods().get(methodName);
        result.append(addSlashToTheEndIfNotExist(method));

        return result.toString();
    }

    private String addSlashToTheEndIfNotExist(String string) {
        return string.endsWith(SLASH) ? string : string + SLASH;
    }

}
