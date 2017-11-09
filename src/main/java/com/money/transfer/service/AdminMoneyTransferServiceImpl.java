package com.money.transfer.service;

import com.money.transfer.http.client.AdminRemitOneHttpClient;
import com.money.transfer.http.client.response.impl.GetSourceCountriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminMoneyTransferServiceImpl implements AdminMoneyTransferService {

    @Autowired
    private AdminRemitOneHttpClient adminRemitOneHttpClient;

    @Override
    public GetSourceCountriesResponse getSourceCountries() {
        return adminRemitOneHttpClient.getSourceCountries();
    }
}
