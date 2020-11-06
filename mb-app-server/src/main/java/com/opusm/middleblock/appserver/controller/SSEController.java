package com.opusm.middleblock.appserver.controller;

import com.opusm.middleblock.appserver.util.SseEmitterMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;


@RestController
@RequestMapping("/sse/mvc")
public class SSEController {

    private static final Logger logger = LoggerFactory.getLogger(SSEController.class);

    @Autowired
    public SseEmitterMap ssemap;

    @GetMapping(path = "/words", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    SseEmitter getWords(@RequestHeader(name = "Last-Event-ID", required = false) String lastId, @RequestParam(value = "id") String id) {
        SseEmitter emitter = new SseEmitter();
        logger.info("Emitter created: {} - {}", id, emitter);
        ssemap.add(id, emitter);

        return emitter;
    }

}
