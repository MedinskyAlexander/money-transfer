package com.money.transfer.http.client.properties;

import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
public class Group {
    private String name;
    private Map<String, String> methods;
}


