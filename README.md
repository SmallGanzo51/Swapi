# SWAPI Java Client

Приложение на Java для поиска персонажей, планет и фильмов по API [SWAPI](https://swapi.dev/).

## Особенности

- Поддержка русского ввода через словарь (`dictionary.txt`)
- Автоматический перевод на английские имена для SWAPI
- Поиск персонажей, планет и фильмов
- Вывод основной информации и связанных объектов
- Логирование с помощью log4j 2
- DTO с Jackson для корректного парсинга JSON
- Unit-тесты с JUnit

## Сборка и запуск

```bash
./gradlew clean fatJar
java -jar app/build/libs/swapi-app.jar

