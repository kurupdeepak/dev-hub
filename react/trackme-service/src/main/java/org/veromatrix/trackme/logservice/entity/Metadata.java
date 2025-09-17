package org.veromatrix.trackme.logservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metadata {
    private String mood;
    private String location;
    private String source;
    private Double confidence;

    public Metadata() {
        this.mood = "Neutral";
        this.location = "Home";
        this.source = "Manual";
        this.confidence = 0.75;
    }
}
