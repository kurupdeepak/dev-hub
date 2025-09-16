package org.veromatrix.trame.entryservice.web;

import org.springframework.stereotype.Service;
import org.veromatrix.trame.entryservice.entity.LogEntry;
import org.veromatrix.trame.entryservice.repository.LogEntryRepository;
import org.veromatrix.trame.entryservice.transfer.LogEntryTO;
import org.veromatrix.trame.entryservice.web.mapper.LogEntryMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class LogEntryService {
    private final LogEntryRepository entryRepository;

    private final LogEntryMapper mapper;

    public LogEntryService(LogEntryRepository entryRepository, LogEntryMapper mapper) {
        this.entryRepository = entryRepository;
        this.mapper = mapper;
    }

    public List<LogEntryTO> getAllEntries(LocalDate day) {
        List<LogEntry> allByDay = entryRepository.findAllByDayIsActive(day);
        return mapper.mapFromEntityAsList(allByDay);
    }

    ;

    public LogEntryTO getEntry(String logId) {
        Optional<LogEntry> idResult = entryRepository.findById(logId);
        if (idResult.isEmpty()) {
            throw new EntryServiceException("Log entry with id [" + logId + "] not found");
        }
        return mapper.mapFromEntity(idResult.get());
    }

    ;

    public LogEntryTO saveEntry(LogEntryTO entry) {
        LogEntry entryEntity = mapper.mapToEntity(entry);
        LogEntry savedEntry = entryRepository.save(entryEntity);
        return mapper.mapFromEntity(savedEntry);
    }

    public LogEntryTO updateEntry(String logId, LogEntryTO entry) {
        Optional<LogEntry> idResult = entryRepository.findById(logId);
        if (idResult.isEmpty()) {
            throw new EntryServiceException("Log entry with id [" + logId + "] not found");
        }
        LogEntry existing = idResult.get();
        LogEntry entity = mapper.mergeToEntity(entry, existing);
        LogEntry result = entryRepository.save(entity);
        return mapper.mapFromEntity(result);
    }

    public LogEntryTO patchEntry(String logId, LogEntryTO entry) {
        Optional<LogEntry> idResult = entryRepository.findById(logId);
        if (idResult.isEmpty()) {
            throw new EntryServiceException("Log entry with id [" + logId + "] not found");
        }
        LogEntry existing = idResult.get();
        LogEntry existingPatched = mapper.patchToEntity(entry, existing);
        return mapper.mapFromEntity(entryRepository.save(existingPatched));
    }

    public boolean deleteEntry(String logId) {
        Optional<LogEntry> existingEntry = entryRepository.findById(logId);
        if (existingEntry.isEmpty()) {
            throw new EntryServiceException("Log existingEntry with id [" + logId + "] not found");
        }
        LogEntry entry = existingEntry.get();
        entry.setActive(false);
        patchEntry(logId, mapper.mapFromEntity(entry));
        return true;
    }
}
