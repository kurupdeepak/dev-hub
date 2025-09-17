package org.veromatrix.trackme.logservice.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Document(collection="log_entries")
@Data
public class LogEntry {
    @Id
    private String id;

    @Field("entry_id")
    private Long entryId;

    private LocalDate day;

    private Long timestamp = Instant.now().getEpochSecond();

    private String category;

    @Field("sub_category")
    private String subCategory;

    private String content;

    private List<String> tags;

    private Metadata metadata;

    private Boolean active;
}
