package org.veromatrix.trame.entryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.veromatrix.trame.entryservice.entity.LogEntry;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LogEntryRepository extends MongoRepository<LogEntry,String> {
    List<LogEntry> findAllByDayAndActive(LocalDate dateFilter,boolean isActive);
    Optional<LogEntry> findByEntryId(Long entryId);
    List<LogEntry> findAllByDay(LocalDate dateFilter);
}
