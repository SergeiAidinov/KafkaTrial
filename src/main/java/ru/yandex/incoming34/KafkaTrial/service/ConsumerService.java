package ru.yandex.incoming34.KafkaTrial.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@EnableKafka
@Service
public class ConsumerService {

    @KafkaListener(topics = {"test"}, groupId = "key")
    private void listen(ConsumerRecord<String, String> record) {
        record.value();
        System.out.println("====> " + record.value());



    }
    }



