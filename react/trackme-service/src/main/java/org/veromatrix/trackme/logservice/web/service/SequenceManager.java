package org.veromatrix.trackme.logservice.web.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.veromatrix.trackme.logservice.entity.SequenceStateEntry;
import org.veromatrix.trackme.logservice.repository.SequenceRepository;
import org.veromatrix.trackme.logservice.web.EntryServiceException;

import java.time.LocalDate;
import java.util.Optional;

@Component
public class SequenceManager {
    private final SequenceRepository repository;

    public SequenceManager(SequenceRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Long nextId(String collection){
        Optional<SequenceStateEntry> sequenceEntry = repository.findByCollectionName(collection);
        if(sequenceEntry.isEmpty()){
            throw new EntryServiceException("Sequence Generator failed for " + collection);
        }
        SequenceStateEntry entry = sequenceEntry.get();
        long newValue = entry.getSequenceId() + 1;
        entry.setSequenceId(newValue);
        entry.setEntryDate(LocalDate.now());
        repository.save(entry);
        return newValue;
    }

    public Long currentId(String collection){
        Optional<SequenceStateEntry> sequenceEntry = repository.findByCollectionName(collection);
        if(sequenceEntry.isEmpty()){
            throw new EntryServiceException("Sequence Generator failed for " + collection);
        }
        SequenceStateEntry entry = sequenceEntry.get();
        return entry.getSequenceId();
    }
}
