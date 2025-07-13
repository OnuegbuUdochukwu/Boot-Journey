package com.codewithudo.personaldiaryapi.controller;

import com.codewithudo.personaldiaryapi.model.DiaryEntry;
import com.codewithudo.personaldiaryapi.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diary")
public class DiaryController {

    @Autowired
    private DiaryService diaryService;

    // Add a new diary entry
    @PostMapping
    public ResponseEntity<String> createEntry(@RequestBody DiaryEntry entry) {
        boolean added = diaryService.addEntry(entry);
        if (added) {
            return new ResponseEntity<>("Entry added successfully", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add entry", HttpStatus.BAD_REQUEST);
    }

    // Get all entries
    @GetMapping
    public ResponseEntity<List<DiaryEntry>> getAllEntries() {
        return new ResponseEntity<>(diaryService.getAllEntries(), HttpStatus.OK);
    }

    // Get a specific entry by ID
    @GetMapping("/{id}")
    public ResponseEntity<DiaryEntry> getEntryById(@PathVariable int id) {
        DiaryEntry entry = diaryService.getEntryById(id);
        if (entry != null) {
            return new ResponseEntity<>(entry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update an entry by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEntry(@PathVariable int id, @RequestBody DiaryEntry entry) {
        boolean updated = diaryService.updateEntry(id, entry);
        if (updated) {
            return new ResponseEntity<>("Entry updated successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Entry not found", HttpStatus.NOT_FOUND);
    }

    // Delete an entry by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEntry(@PathVariable int id) {
        boolean deleted = diaryService.deleteEntry(id);
        if (deleted) {
            return new ResponseEntity<>("Entry deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Entry not found", HttpStatus.NOT_FOUND);
    }
}
