package com.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize
@JsonSerialize
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stereo {
    private String colour;
    private Integer speakers;
    @JsonCreator
    public Stereo(@JsonProperty("colour") String colour, @JsonProperty("speakers") Integer speakers) {
        this.colour = colour;
        this.speakers = speakers;
    }
    @JsonProperty("colour")
    public String getColour() {
        return colour;
    }
    @JsonProperty("speakers")
    public Integer getSpeakers() {
        return speakers;
    }
}
