package util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Утилитарный класс для парсинга JSON в объекты DTO.
 */
public class JsonParser {

    private static final Logger logger = LogManager.getLogger(JsonParser.class);
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonParser() {
        // Приватный конструктор, чтобы класс нельзя было инстанцировать
    }

    /**
     * Преобразует JSON-строку в объект указанного класса.
     *
     * @param json  JSON-строка
     * @param clazz класс, в который нужно преобразовать
     * @param <T>   тип объекта
     * @return объект класса T или null при ошибке
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            logger.error("Ошибка при парсинге JSON в {}", clazz.getSimpleName(), e);
            return null;
        }
    }

    /**
     * Преобразует объект в JSON-строку.
     *
     * @param obj объект для сериализации
     * @return JSON-строка или null при ошибке
     */
    public static String toJson(Object obj) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (IOException e) {
            logger.error("Ошибка при сериализации объекта в JSON: {}", obj.getClass().getSimpleName(), e);
            return null;
        }
    }
}
