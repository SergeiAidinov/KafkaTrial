package ru.yandex.incoming34.KafkaTrial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@EnableKafka
@Component
public class Producer {

    @Value("${spring.kafka.producer.topic}")
    String topic;

    Logger logger = Logger.getLogger(String.valueOf(Producer.class));

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg) {
        kafkaTemplate.send(topic, msg);
    }

}
