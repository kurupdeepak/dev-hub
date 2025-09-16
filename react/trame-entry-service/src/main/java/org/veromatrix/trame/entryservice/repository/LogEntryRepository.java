package org.veromatrix.trame.entryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.veromatrix.trame.entryservice.entity.LogEntry;

import java.time.LocalDate;
import java.util.List;

public interface LogEntryRepository extends MongoRepository<LogEntry,String> {
    List<LogEntry> findAllByDayIsActive(LocalDate dateFilter);
    List<LogEntry> findAllByDay(LocalDate dateFilter);
}
