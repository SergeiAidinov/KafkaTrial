package ru.yandex.incoming34.KafkaTrial;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@EnableKafka
@Component
public class ConsumerService {

    @KafkaListener(topics = "topic", groupId = "key")
    private void listen(ConsumerRecord<String, String> record) {

        record.value();



    }
    }



