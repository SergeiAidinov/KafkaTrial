package ru.yandex.incoming34.KafkaTrial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@Getter
public class Product {

    private final UUID id;
    private final String description;
    private final int price;

}
