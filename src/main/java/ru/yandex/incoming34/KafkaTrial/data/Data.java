package ru.yandex.incoming34.KafkaTrial.data;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class Data {

    public static Map<String, Integer> products = new HashMap<>();

    Data() {
        products.putAll(part1);
        products.putAll(part2);
    }

    private static Map<String, Integer> part1 = Map.of(
            "Простой карандаш", 2,
            "Ручка", 5,
            "Цветной карандаш", 4,
            "Ножницы маленькие", 20,
            "Ножницы большие", 30,
            "Степлер", 35,
            "Фломастеры", 15,
            "Линейка", 3,
            "Циркуль", 12,
            "Ластик", 3
    );

    private static Map<String, Integer> part2 = Map.of(
            "Дырокол",  40,
            "Папка для бумаг", 7,
            "Скоросшиватель", 9,
            "Блокнот", 11,
            "Точилка", 6,
            "Кисточка", 8,
            "Гуашь", 13,
            "Корректор", 9,
            "Шило канцелярское", 10,
            "Транспортир", 6
    );


}
