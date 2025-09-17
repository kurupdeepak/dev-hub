package org.veromatrix.trackme.logservice.transfer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MetadataTO {
    private String mood = "Neutral";
    private String location = "Home";
    private String source = "Manual";
    private Double confidence = 0.75;
}
