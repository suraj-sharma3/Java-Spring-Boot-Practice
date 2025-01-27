package com.esteam.everJournal.controller;

import com.esteam.everJournal.entity.JournalEntry;
import com.esteam.everJournal.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/journal")
class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;
    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @GetMapping("/id/{myID}")
    public JournalEntry getJournalEntryByID(@PathVariable ObjectId myID) {
        return journalEntryService.findById(myID).orElse(null);
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @DeleteMapping("/id/{myID}")
    public boolean deleteEntryByID(@PathVariable ObjectId myID) {
        journalEntryService.deleteById(myID);
        return true;
    }

    @PutMapping("/id/{myID}")
    public JournalEntry updateEntryByID(@PathVariable ObjectId myID, @RequestBody JournalEntry updatedEntry) {
        JournalEntry existingEntry = journalEntryService.findById(myID).orElse(null);
        if(existingEntry != null){
            existingEntry.setTitle(updatedEntry.getTitle() != null && !updatedEntry.getTitle().equals("") ? updatedEntry.getTitle() : existingEntry.getTitle());
            existingEntry.setContent(updatedEntry.getContent() != null && !updatedEntry.getContent().equals("") ? updatedEntry.getContent() : existingEntry.getContent());
        }
        journalEntryService.saveEntry(existingEntry);
        return existingEntry;
    }

}
