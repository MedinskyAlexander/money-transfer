package com.money.transfer.controller;

import com.money.transfer.http.client.response.impl.GetAgentDetailsResponse;
import com.money.transfer.service.AgentMoneyTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("money-transfer/agent")
public class AgentMoneyTransferController {

    @Autowired
    private AgentMoneyTransferService agentMoneyTransferService;

    @RequestMapping(value = "/details", method = RequestMethod.GET, produces = "application/json")
    public GetAgentDetailsResponse getAgentDetails() {
        return agentMoneyTransferService.getAgentDetails();
    }


}
