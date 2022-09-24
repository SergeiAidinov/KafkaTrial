package ru.yandex.incoming34.KafkaTrial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProducerTest {

    @Autowired
    Producer producer;

    @Test
    public void sendMessageTest(){
        producer.sendMessage("Shalom!!!");
    }

}