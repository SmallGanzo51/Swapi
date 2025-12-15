package dto;

/**
 * Класс, описывающий запись словаря:
 * тип запроса (person, film, planet) и значение для API
 */
public class DictionaryEntry {

    private final String type;
    private final String value;

    public DictionaryEntry(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
