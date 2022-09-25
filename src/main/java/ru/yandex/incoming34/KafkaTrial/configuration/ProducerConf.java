package ru.yandex.incoming34.KafkaTrial.configuration;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class ProducerConf {

    @Value("${spring.kafka.producer.bootstrap-servers}")
    String bootstrapServers;

    @Value("${spring.kafka.producer.topic}")
    String topic;

    @Value("${spring.kafka.producer.port}")
    int port;

    @Bean
    String getBootstrapServers() {
        return bootstrapServers;
    }

    public DefaultKafkaProducerFactory producerFactory() {
        Map<Object, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory(configProps);
    }

    @Bean
    public Producer producer(){
        Producer p = producerFactory().createProducer();
        return p;

    }

}
