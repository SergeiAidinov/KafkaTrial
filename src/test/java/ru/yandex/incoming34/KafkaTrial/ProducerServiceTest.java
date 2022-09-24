package ru.yandex.incoming34.KafkaTrial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerServiceTest {

    @Autowired
    ProducerService producerService;

    @Test
    public void sendMessageTest(){
        producerService.sendMessage("Привет с большого бодуна!!!");
    }

}