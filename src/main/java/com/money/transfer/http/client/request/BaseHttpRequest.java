package com.money.transfer.http.client.request;

import com.money.transfer.http.client.properties.Credentials;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
@Builder
public class BaseHttpRequest {

    private String username;
    private String password;
    private String pin;

    public static class BaseHttpRequestBuilder {
        public BaseHttpRequestBuilder credentials(Credentials credentials) {
            this.username = credentials.getUsername();
            this.password = credentials.getPassword();
            this.pin = credentials.getPin();
            return this;
        }

    }


}
