package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * DTO персонажа SWAPI
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDTO {

    private String name;
    private String height;
    private String mass;
    private String gender;

    @JsonProperty("homeworld")
    private String homeworldUrl;

    private List<String> films;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getHeight() { return height; }
    public void setHeight(String height) { this.height = height; }

    public String getMass() { return mass; }
    public void setMass(String mass) { this.mass = mass; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getHomeworldUrl() { return homeworldUrl; }
    public void setHomeworldUrl(String homeworldUrl) { this.homeworldUrl = homeworldUrl; }

    public List<String> getFilms() { return films; }
    public void setFilms(List<String> films) { this.films = films; }
}
