package com.money.transfer.http.client.response.impl;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.money.transfer.http.client.response.BaseResponse;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class GetSourceCountriesResponse extends BaseResponse {

    @JacksonXmlProperty(localName = "result")
    private Result result;

    @Data
    @ToString
    public class Result {

        @JacksonXmlProperty(localName = "countries")
        private Country[] countries;

    }

}
