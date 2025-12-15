package dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * DTO для планет SWAPI
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetDTO {

    private String name;
    private String climate;
    private String terrain;
    private String population;

    @JsonProperty("gravity")
    private String gravityValue;

    // Геттеры и сеттеры
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getClimate() { return climate; }
    public void setClimate(String climate) { this.climate = climate; }

    public String getTerrain() { return terrain; }
    public void setTerrain(String terrain) { this.terrain = terrain; }

    public String getPopulation() { return population; }
    public void setPopulation(String population) { this.population = population; }

    public String getGravityValue() { return gravityValue; }
    public void setGravityValue(String gravityValue) { this.gravityValue = gravityValue; }
}
