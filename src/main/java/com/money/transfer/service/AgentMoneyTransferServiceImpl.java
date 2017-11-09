package com.money.transfer.service;

import com.money.transfer.http.client.AgentRemitOneHttpClient;
import com.money.transfer.http.client.response.impl.GetAgentDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentMoneyTransferServiceImpl implements AgentMoneyTransferService {

    @Autowired
    private AgentRemitOneHttpClient agentRemitOneHttpClient;

    @Override
    public GetAgentDetailsResponse getAgentDetails() {
        return agentRemitOneHttpClient.getAgentDetails();
    }
}
