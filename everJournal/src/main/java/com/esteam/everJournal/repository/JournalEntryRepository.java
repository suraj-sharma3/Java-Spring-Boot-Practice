package com.esteam.everJournal.repository;

import com.esteam.everJournal.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository <JournalEntry, String> {
}
