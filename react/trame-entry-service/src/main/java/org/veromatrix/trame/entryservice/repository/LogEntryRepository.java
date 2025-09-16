package org.veromatrix.trame.entryservice.entity.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.veromatrix.trame.entryservice.entity.LogEntry;

public interface LogEntryRepository extends MongoRepository<LogEntry,String> {
}
