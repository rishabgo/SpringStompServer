package com.rishabh.SpringStompServer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class StompMessageBroadcastingServiceImpl implements StompMessageBroadcastingService {

    private Logger logger = LoggerFactory.getLogger(StompMessageBroadcastingServiceImpl.class);
    private SimpMessagingTemplate simpMessagingTemplate;

    public StompMessageBroadcastingServiceImpl(SimpMessagingTemplate messagingTemplate) {
        this.simpMessagingTemplate = messagingTemplate;
    }

    @Override
    public void sendMessage(final String destination, @Payload String message) {
        logger.info("Sending message to stomp destination {}", destination);
        simpMessagingTemplate.convertAndSend(destination, message);
    }
}
