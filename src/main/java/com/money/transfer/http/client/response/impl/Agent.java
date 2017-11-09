package com.money.transfer.http.client.response.impl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Currency;

@Data
@ToString
public class Agent {

    @JacksonXmlProperty(localName = "id")
    private String id;
    @JacksonXmlProperty(localName = "username")
    private String username;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "country")
    private String country;
    @JacksonXmlProperty(localName = "currency")
    private Currency currency;
    @JacksonXmlProperty(localName = "destination_countries")
    private Country[] countries;


}
