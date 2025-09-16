package org.veromatrix.trame.entryservice.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metadata {
    private String mood;
    private String location;
    private String source;
    private Double confidence;
}
