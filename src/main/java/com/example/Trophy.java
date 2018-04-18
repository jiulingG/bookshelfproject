package com.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class Trophy {
    private String type;
    private String name;
    private Integer year;

    public Trophy(@JsonProperty("type") String type,@JsonProperty("name") String name, @JsonProperty("year")Integer year) {
        this.type = type;
        this.name = name;
        this.year = year;
    }
    @JsonProperty("type")
    public String getType() {
        return type;
    }
    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("year")
    public Integer getYear() {
        return year;
    }
}
