package org.veromatrix.trame.entryservice.transfer;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class LogEntryTO {
    private String id;
    private LocalDate day;
    private LocalDateTime timestamp;
    private String category;
    private String subCategory;
    private String content;
    private List<String> tags;
    private MetadataTO metadata;
    private boolean isActive;
}
