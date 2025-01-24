package com.esteam.everJournal.controller;

import com.esteam.everJournal.entity.JournalEntry;
import com.esteam.everJournal.service.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
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
    public JournalEntry getJournalEntryByID(@PathVariable Long myID) {
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        journalEntryService.saveEntry(myEntry);
        return true;
    }

    @DeleteMapping("/id/{myID}")
    public JournalEntry deleteEntryByID(@PathVariable Long myID) {
        return null;
    }

    @PutMapping("/id/{myID}")
    public JournalEntry updateEntryByID(@PathVariable Long myID, @RequestBody JournalEntry updatedEntry) {
        return null;
    }

}
