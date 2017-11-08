package com.money.transfer;

import com.money.transfer.http.client.HttpClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RemitOneHttpClientTests {

    @Autowired
    private HttpClient httpClient;

	@Test
    public void agentDataResponseIsNoEmptyTest() {
        String result = httpClient.getAgentDetails();
        assertNotEquals(0, result.length());
    }

    @Test
    public void adminSourceCountriesResponseIsNoEmptyTest() {
        String result = httpClient.getSourceCountries();
        assertNotEquals(0, result.length());
    }

}
