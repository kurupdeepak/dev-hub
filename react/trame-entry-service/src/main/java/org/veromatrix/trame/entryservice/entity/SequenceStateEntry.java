package org.veromatrix.trame.entryservice.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document(collection = "sequence_state")
public class SequenceStateEntry {
    private String id;

    @Field("sequence_id")
    private Long sequenceId;

    @Field("entry_date")
    private LocalDate entryDate;

    @Field("collection_name")
    private String collectionName;

    private boolean active;
    @Field("inactivated_on")

    private LocalDateTime inactivatedOn;

    @Field("created_date")
    private LocalDateTime createdDate;
}
