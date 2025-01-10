package com.esteam.everJournal.controller;

import com.esteam.everJournal.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import  java.util.List;

@RestController
@RequestMapping("/journal")
class JournalEntryController {
    private HashMap<Long, JournalEntry> journalEntries = new HashMap<Long, JournalEntry>();

    // REST API

    //GET request
    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
    }

    //GET request
    @GetMapping("/id/{myID}")
    public JournalEntry getJournalEntryByID(@PathVariable Long myID){
        return journalEntries.get(myID);
    }

    //POST request
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    //DELETE request
    @DeleteMapping("/id/{myID}")
    public JournalEntry deleteEntryByID(@PathVariable Long myID){
        return journalEntries.remove(myID);
    }

    // PUT or UPDATE request
    @PutMapping("/id/{myID}")
    public JournalEntry updateEntryByID(@PathVariable Long myID, @RequestBody JournalEntry updatedEntry){
        return journalEntries.put(myID, updatedEntry);
    }

}
