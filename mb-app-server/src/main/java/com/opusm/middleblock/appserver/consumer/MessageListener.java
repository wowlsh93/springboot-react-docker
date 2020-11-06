package com.opusm.middleblock.appserver.consumer;

import com.opusm.middleblock.appserver.constants.KafkaConstants;
import com.opusm.middleblock.appserver.controller.UserController;
import com.opusm.middleblock.appserver.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);


    @KafkaListener(
            topics = KafkaConstants.KAFKA_TOPIC,
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Message message) {
        System.out.println("sending via kafka listener..");
        logger.debug("sending via kafka listener..");

    }
}
