import dto.DictionaryEntry;
import dto.PersonDTO;
import dto.PlanetDTO;
import dto.FilmDTO;
import service.DictionaryService;
import service.SwapiService;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public static void main(String[] args) {

        DictionaryService dictionaryService = new DictionaryService();
        SwapiService swapiService = new SwapiService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя персонажа, планеты или фильма (или 'dictionary' для просмотра списка):");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("exit")) break;
            if (input.equals("dictionary")) {
                dictionaryService.printDictionary();
                continue;
            }

            if (!dictionaryService.contains(input)) {
                logger.info("Запрос не найден в словаре");
                System.out.println("Запрос не найден в словаре");
                continue;
            }

            DictionaryEntry entry = dictionaryService.getEntry(input);

            switch (entry.getType()) {
                case "person":
                    try {
                        PersonDTO person = swapiService.getPersonByName(entry.getValue());
                        if (person != null) {
                            System.out.println("Имя: " + person.getName());
                            System.out.println("Пол: " + person.getGender());
                            System.out.println("Рост: " + person.getHeight());
                            System.out.println("Фильмы:");
                            if (person.getFilms() != null) {
                                for (String filmUrl : person.getFilms()) {
                                    FilmDTO film = swapiService.getFilmByUrl(filmUrl);
                                    System.out.println("- " + film.getTitle() + " (" + film.getReleaseDate() + ")");
                                }
                            }
                        } else {
                            System.out.println("Персонаж не найден");
                        }
                    } catch (Exception e) {
                        logger.error("Ошибка получения персонажа", e);
                        System.out.println("Персонаж не найден");
                    }
                    break;

                case "film":
                    try {
                        FilmDTO film = swapiService.getFilmByTitle(entry.getValue());
                        if (film != null) {
                            System.out.println("Фильм: " + film.getTitle());
                            System.out.println("Режиссёр: " + film.getDirector());
                            System.out.println("Дата выхода: " + film.getReleaseDate());
                        } else {
                            System.out.println("Фильм не найден");
                        }
                    } catch (Exception e) {
                        logger.error("Ошибка получения фильма", e);
                        System.out.println("Фильм не найден");
                    }
                    break;

                case "planet":
                    try {
                        PlanetDTO planet = swapiService.getPlanetByName(entry.getValue());
                        if (planet != null) {
                            System.out.println("Планета: " + planet.getName());
                            System.out.println("Климат: " + planet.getClimate());
                            System.out.println("Рельеф: " + planet.getTerrain());
                            System.out.println("Население: " + planet.getPopulation());
                        } else {
                            System.out.println("Планета не найдена");
                        }
                    } catch (Exception e) {
                        logger.error("Ошибка получения планеты", e);
                        System.out.println("Планета не найдена");
                    }
                    break;

                default:
                    System.out.println("Неизвестный тип запроса");
                    break;
            }
        }

        scanner.close();
        System.out.println("Выход из приложения");
    }
}
