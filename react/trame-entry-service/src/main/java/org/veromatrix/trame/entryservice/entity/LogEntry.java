package org.veromatrix.trame.entryservice.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection="log_entries")
@Getter@Setter
public class LogEntry {
    @Id
    private String id;
    private LocalDate day;
    private LocalDateTime timestamp;
    private String category;
    private String subCategory;
    private String content;
    private List<String> tags;
    private Metadata metadata;
    private boolean active;
}
