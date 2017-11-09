package com.money.transfer;

import com.money.transfer.http.client.HttpClient;
import com.money.transfer.http.client.response.impl.GetAgentDetailsResponse;
import com.money.transfer.http.client.response.impl.GetSourceCountriesResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemitOneHttpClientTests {

    @Autowired
    private HttpClient httpClient;


	@Test
    public void agentDataResponseIsNoEmptyTest() {
        GetAgentDetailsResponse response = httpClient.getAgentDetails();
        assertNotNull(response);
    }

    @Test
    public void adminSourceCountriesResponseIsNoEmptyTest() {
        GetSourceCountriesResponse response = httpClient.getSourceCountries();
        assertNotNull(response);
    }

}
