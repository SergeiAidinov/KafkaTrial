package ru.yandex.incoming34.KafkaTrial;

import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.incoming34.KafkaTrial.dto.Product;
import ru.yandex.incoming34.KafkaTrial.service.ProducerService;

import java.util.UUID;

@SpringBootTest
class ProducerServiceTest {

    @Autowired
    public ProducerService producerService;

    private Gson gson = new Gson();

    @Test
    void contextLoads() {
    }


    @Test
    public void sendMessageTest(){
        Product product = new Product(UUID.randomUUID(), "Pencil", 12);
        String json = gson.toJson(product);
        producerService.sendMessage(json);
    }

}