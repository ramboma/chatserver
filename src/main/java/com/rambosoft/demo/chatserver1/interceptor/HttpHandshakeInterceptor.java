package com.rambosoft.demo.chatserver1.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by rambo on 2019/3/23.
 */
@Component
public class HttpHandshakeInterceptor implements HandshakeInterceptor {

    private static final Logger logger= LoggerFactory.getLogger(HttpHandshakeInterceptor.class);

    @Override
    public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
                                   WebSocketHandler webSocketHandler, Map<String, Object> map) throws Exception {
        logger.info("before handshake");
        if(serverHttpRequest instanceof ServletServerHttpRequest)
        {
            ServletServerHttpRequest request=(ServletServerHttpRequest)serverHttpRequest;
            HttpSession session=request.getServletRequest().getSession();
            map.put("sessionid",session.getId());
        }
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse, WebSocketHandler webSocketHandler, @Nullable Exception e) {
        logger.info("call after handshake");
    }
}
