package com.money.transfer.service;


import com.money.transfer.http.client.response.impl.GetAgentDetailsResponse;

public interface AgentMoneyTransferService {

    GetAgentDetailsResponse getAgentDetails();

}
