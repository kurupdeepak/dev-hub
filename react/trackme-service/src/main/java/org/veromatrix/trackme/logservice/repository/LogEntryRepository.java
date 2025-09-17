package org.veromatrix.trackme.logservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.veromatrix.trackme.logservice.entity.LogEntry;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface LogEntryRepository extends MongoRepository<LogEntry,String> {
    List<LogEntry> findAllByDayAndActive(LocalDate dateFilter,boolean isActive);
    Optional<LogEntry> findByEntryId(Long entryId);
    List<LogEntry> findAllByDay(LocalDate dateFilter);
}
