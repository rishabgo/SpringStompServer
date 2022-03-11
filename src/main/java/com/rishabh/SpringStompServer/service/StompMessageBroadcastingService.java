package com.rishabh.SpringStompServer.service;

public interface StompMessageBroadcastingService {

    void sendMessage(final String destination, final String message);
}
