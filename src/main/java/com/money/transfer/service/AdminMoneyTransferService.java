package com.money.transfer.service;


import com.money.transfer.http.client.response.impl.GetSourceCountriesResponse;

public interface AdminMoneyTransferService {

    GetSourceCountriesResponse getSourceCountries();

}
