package ru.yandex.incoming34.KafkaTrial.service;

import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.yandex.incoming34.KafkaTrial.dto.Product;

import java.util.logging.Logger;

@EnableKafka
@Service
public class ConsumerService {
    Gson gson = new Gson();
    Logger logger = Logger.getLogger(String.valueOf(ConsumerService.class));

    @KafkaListener(topics = {"test"}, groupId = "key")
    private void listen(ConsumerRecord<String, String> record) {
        String jsonString = record.value();
        Product product = gson.fromJson(jsonString, Product.class);
        logger.info("====> Получен товар: " + product.toString());

    }

}



