package com.money.transfer.http.client.response.impl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

import java.util.Currency;
import java.util.List;

@Data

@ToString
@JacksonXmlRootElement(localName = "country")
public class Country {

    @JacksonXmlProperty(localName = "id")
    private String id;
    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "iso_code")
    private String isoCode;
    @JacksonXmlProperty(localName = "code")
    private String code;
    @JacksonXmlProperty(localName = "currency")
    private Currency currency;
    @JacksonXmlProperty(localName = "allowed_currencies")
    private List<Currency> allowedCurrencies;

}
