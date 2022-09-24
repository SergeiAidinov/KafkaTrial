package ru.yandex.incoming34.KafkaTrial;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@EnableKafka
@Component
public class ProducerService {

    @Value("${spring.kafka.producer.topic}")
    String topic;

    Logger logger = Logger.getLogger(String.valueOf(ProducerService.class));

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    Producer producer;

    public void sendMessage(String msg) {
        ProducerRecord<String, String> record = new ProducerRecord("topic", "key", msg);


        producer.send(record);

    }

}
