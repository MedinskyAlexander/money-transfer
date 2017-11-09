package com.money.transfer.controller;

import com.money.transfer.http.client.response.impl.GetSourceCountriesResponse;
import com.money.transfer.service.AdminMoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("money-transfer/admin")
public class AdminMoneyTransferController {

    @Autowired
    private AdminMoneyTransferService adminMoneyTransferService;

    @RequestMapping(value = "/source-countries", method = RequestMethod.GET, produces = "application/json")
    public GetSourceCountriesResponse getSourceCountriesResponse() {
        return adminMoneyTransferService.getSourceCountries();
    }

}
