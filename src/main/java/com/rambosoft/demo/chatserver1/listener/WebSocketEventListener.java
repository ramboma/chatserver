package com.rambosoft.demo.chatserver1.listener;

import com.rambosoft.demo.chatserver1.interceptor.HttpHandshakeInterceptor;
import com.rambosoft.demo.chatserver1.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * Created by rambo on 2019/3/23.
 */
@Component
public class WebSocketEventListener {
    private static final Logger logger= LoggerFactory.getLogger(HttpHandshakeInterceptor.class);

    @Autowired
    private SimpMessageSendingOperations messageSendingOperations;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event)
    {
        logger.info("receive a new connect");
    }
    public void handlerWebSocketDisconnectListener(SessionDisconnectEvent event)
    {
        StompHeaderAccessor stompHeaderAccessor=StompHeaderAccessor.wrap(event.getMessage());
        String username=(String)stompHeaderAccessor.getSessionAttributes().get("username");
        if(username!=null)
        {
            logger.info("user disconnect "+username);
            ChatMessage chatMessage=new ChatMessage();
            chatMessage.setType(ChatMessage.MessageType.LEVEL);
            chatMessage.setSender(username);

            messageSendingOperations.convertAndSend("/topic/publicChatRoom",chatMessage);
        }
    }
}
