package service;

import dto.DictionaryEntry;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Сервис для работы со словарём: русский ввод -> тип запроса + значение для SWAPI
 */
public class DictionaryService {

    private final Map<String, DictionaryEntry> dictionary = new HashMap<>();

    public DictionaryService() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        getClass().getClassLoader().getResourceAsStream("dictionary.txt")
                ))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty() || !line.contains("=")) {
                    continue; // пропускаем пустые или некорректные строки
                }

                String[] parts = line.split("=", 2);
                String[] valueParts = parts[1].split(":", 2);

                if (valueParts.length != 2) continue; // если нет типа или значения

                dictionary.put(
                        parts[0].trim().toLowerCase(),
                        new DictionaryEntry(valueParts[0].trim().toLowerCase(), valueParts[1].trim().toLowerCase())
                );
            }

        } catch (Exception e) {
            throw new RuntimeException("Ошибка загрузки dictionary.txt", e);
        }
    }

    public boolean contains(String key) {
        return dictionary.containsKey(key.toLowerCase());
    }

    public DictionaryEntry getEntry(String key) {
        return dictionary.get(key.toLowerCase());
    }

    public void printDictionary() {
        dictionary.keySet().forEach(System.out::println);
    }
}
