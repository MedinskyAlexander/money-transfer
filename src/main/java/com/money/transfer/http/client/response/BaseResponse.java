package com.money.transfer.http.client.response;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JacksonXmlRootElement(localName = "response")
public abstract class BaseResponse {

    @JacksonXmlProperty(localName = "responseId")
    private Integer responseId;

    @JacksonXmlProperty(localName = "status")
    private String status;

}
