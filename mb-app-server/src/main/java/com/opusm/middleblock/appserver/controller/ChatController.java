package com.opusm.middleblock.appserver.controller;


import com.opusm.middleblock.appserver.constants.KafkaConstants;
import com.opusm.middleblock.appserver.model.Message;
import com.opusm.middleblock.appserver.payload.ApiResponse;
import com.opusm.middleblock.appserver.payload.JwtAuthenticationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    @PostMapping(value = "/send")
    public ResponseEntity<?>  sendMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now().toString());
        try {
            //Sending the message to kafka topic queue
            logger.debug("send chat essage");
            logger.debug(message.toString());
             kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


        return ResponseEntity.ok(new ApiResponse(true, "ok"));

    }
}
