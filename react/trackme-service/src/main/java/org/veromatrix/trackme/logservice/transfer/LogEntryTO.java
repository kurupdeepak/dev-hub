package org.veromatrix.trackme.logservice.transfer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class LogEntryTO {
    private String id;

    private LocalDate day;

    private Long entryId;

    private Long timestamp;

    private String category;

    @JsonProperty("sub_category")
    private String subCategory;

    private String content;

    private List<String> tags;

    private MetadataTO metadata;

    private Boolean active;
}
