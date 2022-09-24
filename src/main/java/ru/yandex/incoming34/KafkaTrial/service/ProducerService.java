package ru.yandex.incoming34.KafkaTrial.service;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.yandex.incoming34.KafkaTrial.dto.Product;

import java.util.UUID;
import java.util.logging.Logger;

@EnableKafka
@Component
@EnableScheduling
public class ProducerService {

    @Value("${spring.kafka.producer.topic}")
    String topic;

    Logger logger = Logger.getLogger(String.valueOf(ProducerService.class));

    @Autowired
    Producer producer;

    private Gson gson = new Gson();

    public void sendMessage(String product) {
        ProducerRecord<String,String> record = new ProducerRecord("test", "key", product);


        producer.send(record);

    }

    @Scheduled(fixedRate = 1000L)
    private void send(){
        Product product = new Product(UUID.randomUUID(), "Pencil", 12);
        String json = gson.toJson(product);
        sendMessage(json);
    }

}
