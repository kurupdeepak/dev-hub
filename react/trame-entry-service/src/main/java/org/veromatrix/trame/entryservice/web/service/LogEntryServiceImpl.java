package org.veromatrix.trame.entryservice.web.service;

import org.springframework.stereotype.Service;
import org.veromatrix.trame.entryservice.entity.LogEntry;
import org.veromatrix.trame.entryservice.repository.LogEntryRepository;
import org.veromatrix.trame.entryservice.transfer.LogEntryTO;
import org.veromatrix.trame.entryservice.web.EntryServiceException;
import org.veromatrix.trame.entryservice.web.mapper.LogEntryMapper;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class LogEntryServiceImpl implements LogEntryService {
    private static final String COLLECTION_NAME = "log_entries";

    private final LogEntryRepository entryRepository;

    private final SequenceManager sequenceManager;

    private final LogEntryMapper mapper;

    public LogEntryServiceImpl(LogEntryRepository entryRepository,
                               SequenceManager sequenceManager,
                               LogEntryMapper mapper) {
        this.entryRepository = entryRepository;
        this.sequenceManager = sequenceManager;
        this.mapper = mapper;
    }

    @Override
    public List<LogEntryTO> getAllEntries(LocalDate day) {
        List<LogEntry> allByDay = entryRepository.findAllByDayAndActive(day,true);
        return mapper.mapFromEntityAsList(allByDay);
    }

    @Override
    public LogEntryTO getEntry(String entryId) {
        Optional<LogEntry> idResult = entryRepository.findByEntryId(Long.valueOf(entryId));
        if (idResult.isEmpty()) {
            throw new EntryServiceException("Log entry with id [" + entryId + "] not found");
        }
        return mapper.mapFromEntity(idResult.get());
    }

    ;

    @Override
    public LogEntryTO saveEntry(LogEntryTO entry) {
        LogEntry logEntity = mapper.mapToEntity(entry);
        Long l = sequenceManager.nextId(COLLECTION_NAME);
        logEntity.setEntryId(l);
        LogEntry savedEntry = entryRepository.save(logEntity);
        return mapper.mapFromEntity(savedEntry);
    }

    @Override
    public LogEntryTO updateEntry(String entryId, LogEntryTO entry) {
        Optional<LogEntry> idResult = entryRepository.findByEntryId(Long.valueOf(entryId));
        if (idResult.isEmpty()) {
            throw new EntryServiceException("Log entry with id [" + entryId + "] not found");
        }
        LogEntry existing = idResult.get();
        LogEntry entity = mapper.mergeToEntity(entry, existing);
        LogEntry result = entryRepository.save(entity);
        return mapper.mapFromEntity(result);
    }

    @Override
    public LogEntryTO patchEntry(String entryId, LogEntryTO entry) {
        Optional<LogEntry> idResult = entryRepository.findByEntryId(Long.valueOf(entryId));
        if (idResult.isEmpty()) {
            throw new EntryServiceException("Log entry with id [" + entryId + "] not found");
        }
        LogEntry existing = idResult.get();
        LogEntry existingPatched = mapper.patchToEntity(entry, existing);
        return mapper.mapFromEntity(entryRepository.save(existingPatched));
    }

    @Override
    public boolean deleteEntry(String entryId) {
        Optional<LogEntry> existingEntry = entryRepository.findByEntryId(Long.valueOf(entryId));;
        if (existingEntry.isEmpty()) {
            throw new EntryServiceException("Log existingEntry with id [" + entryId + "] not found");
        }
        LogEntry entry = existingEntry.get();
        entry.setActive(false);
        patchEntry(entryId, mapper.mapFromEntity(entry));
        return true;
    }
}
