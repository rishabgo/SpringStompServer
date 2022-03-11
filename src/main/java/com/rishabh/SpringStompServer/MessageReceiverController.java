package com.rishabh.SpringStompServer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rishabh.SpringStompServer.model.Greeting;
import com.rishabh.SpringStompServer.service.StompMessageBroadcastingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageReceiverController {

    private Logger logger = LoggerFactory.getLogger(MessageReceiverController.class);

    @Autowired
    private StompMessageBroadcastingService service;

    @Autowired
    private ObjectMapper mapper;

    @PostMapping("/stomp/request")
    public void receiveMessage(@RequestBody Greeting greeting) throws JsonProcessingException {
       logger.info("Message received from Client");
       service.sendMessage("/topic/greeting", mapper.writeValueAsString(greeting));
    }

}
