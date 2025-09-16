package org.veromatrix.trame.entryservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.veromatrix.trame.entryservice.entity.SequenceStateEntry;

import java.util.Optional;


@Repository
public interface SequenceRepository extends MongoRepository<SequenceStateEntry,String> {
    Optional<SequenceStateEntry> findByCollectionName(String collection);
    Optional<SequenceStateEntry> findByCollectionNameAndActiveTrue(String collection);
}
