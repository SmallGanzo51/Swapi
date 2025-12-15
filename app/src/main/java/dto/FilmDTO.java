package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



/**
 * DTO для фильмов SWAPI
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmDTO {

    private String title;
    private String director;

    @JsonProperty("release_date")
    private String releaseDate;

    private String producer;

    // Геттеры и сеттеры
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public String getProducer() { return producer; }
    public void setProducer(String producer) { this.producer = producer; }
}
