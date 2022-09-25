package ru.yandex.incoming34.KafkaTrial.service;

import com.google.gson.Gson;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.yandex.incoming34.KafkaTrial.dto.Product;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;
import static ru.yandex.incoming34.KafkaTrial.data.Data.products;

@EnableKafka
@Component
@EnableScheduling
public class ProducerService {

    @Value("${spring.kafka.producer.topic}")
    String topic;

    Logger logger = Logger.getLogger(String.valueOf(ProducerService.class));
    Random random = new Random();

    @Autowired
    Producer producer;

    private final Gson gson = new Gson();

    public void sendMessage(String product) {
        ProducerRecord<String,String> record = new ProducerRecord("test", "key", product);
        producer.send(record);
        logger.info("Отправлено сообщение: " + record.value() + " ====>");

    }

    @Scheduled(fixedRate = 1000L)
    private void send(){
        Pair<String, Integer> descriprtionAndPrice = chooseProduct();
        Product product = new Product(UUID.randomUUID(),
                descriprtionAndPrice.getFirst(), descriprtionAndPrice.getSecond());
        String json = gson.toJson(product);
        sendMessage(json);

    }

    private Pair<String, Integer> chooseProduct() {
        int position = random.nextInt(products.size());
        String description = new ArrayList<>(products.keySet()).get(position);
        return Pair.of(description, products.get(description));

    }

}
