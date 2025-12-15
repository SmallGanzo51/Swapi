package service;

import dto.PersonDTO;
import dto.PlanetDTO;
import dto.FilmDTO;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;

/**
 * Сервис для работы с SWAPI
 */
public class SwapiService {

    private static final Logger logger = LogManager.getLogger(SwapiService.class);

    private static final String BASE_URL = "https://swapi.dev/api";

    /**
     * Получить персонажа по имени
     * @param name английское имя персонажа
     * @return PersonDTO или null
     */
    public PersonDTO getPersonByName(String name) {
        try {
            JsonPath jsonPath = RestAssured
                    .given()
                    .queryParam("search", name)
                    .get(BASE_URL + "/people/")
                    .jsonPath();

            List<PersonDTO> results = jsonPath.getList("results", PersonDTO.class);
            if (!results.isEmpty()) {
                return results.get(0);
            }
        } catch (Exception e) {
            logger.error("Ошибка при получении персонажа " + name, e);
        }
        return null;
    }

    /**
     * Получить планету по имени
     * @param name английское имя планеты
     * @return PlanetDTO или null
     */
    public PlanetDTO getPlanetByName(String name) {
        try {
            JsonPath jsonPath = RestAssured
                    .given()
                    .queryParam("search", name)
                    .get(BASE_URL + "/planets/")
                    .jsonPath();

            List<PlanetDTO> results = jsonPath.getList("results", PlanetDTO.class);
            if (!results.isEmpty()) {
                return results.get(0);
            }
        } catch (Exception e) {
            logger.error("Ошибка при получении планеты " + name, e);
        }
        return null;
    }

    /**
     * Получить фильм по названию
     * @param title английское название фильма
     * @return FilmDTO или null
     */
    public FilmDTO getFilmByTitle(String title) {
        try {
            JsonPath jsonPath = RestAssured
                    .given()
                    .queryParam("search", title)
                    .get(BASE_URL + "/films/")
                    .jsonPath();

            List<FilmDTO> results = jsonPath.getList("results", FilmDTO.class);
            if (!results.isEmpty()) {
                return results.get(0);
            }
        } catch (Exception e) {
            logger.error("Ошибка при получении фильма " + title, e);
        }
        return null;
    }

    /**
     * Получить фильм по URL (для списка фильмов персонажа)
     * @param url URL фильма
     * @return FilmDTO или null
     */
    public FilmDTO getFilmByUrl(String url) {
        try {
            return RestAssured
                    .get(url)
                    .jsonPath()
                    .getObject("", FilmDTO.class);
        } catch (Exception e) {
            logger.error("Ошибка при получении фильма по URL: " + url, e);
        }
        return null;
    }
}
