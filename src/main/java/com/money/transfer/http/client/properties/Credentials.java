package com.money.transfer.http.client.properties;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Credentials {
    private String username;
    private String password;
    private String pin;
}
