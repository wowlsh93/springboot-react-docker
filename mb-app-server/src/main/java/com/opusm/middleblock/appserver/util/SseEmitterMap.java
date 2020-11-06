package com.opusm.middleblock.appserver.util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.HashMap;

@Component
public class SseEmitterMap {

    private static final Logger logger = LoggerFactory.getLogger(SseEmitterMap.class);

    private final HashMap<String, SseEmitter> emitters = new HashMap<>();

    public void add(String key, SseEmitter emitter) {
        this.emitters.put(key, emitter);
    }

    public void send(String id, Object obj) throws IOException {
        SseEmitter sse = this.emitters.get(id);
        sse.send("hi");
    }

}
