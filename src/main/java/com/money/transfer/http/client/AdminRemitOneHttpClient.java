package com.money.transfer.http.client;

import com.money.transfer.http.client.response.impl.GetSourceCountriesResponse;

public interface AdminRemitOneHttpClient {

    GetSourceCountriesResponse getSourceCountries();

}
