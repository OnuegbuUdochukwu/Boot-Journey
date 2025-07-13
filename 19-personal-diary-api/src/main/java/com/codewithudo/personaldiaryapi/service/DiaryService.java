package com.codewithudo.personaldiaryapi.service;

import com.codewithudo.personaldiaryapi.model.DiaryEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiaryService {

    private final List<DiaryEntry> entries = new ArrayList<>();
    private int nextId = 1;

    // Add a new diary entry
    public boolean addEntry(DiaryEntry entry) {
        entry.setId(nextId++);
        entries.add(entry);
        return true;
    }

    // Retrieve all entries
    public List<DiaryEntry> getAllEntries() {
        return entries;
    }

    // Retrieve a specific entry by ID
    public DiaryEntry getEntryById(int id) {
        for (DiaryEntry entry : entries) {
            if (entry.getId().equals(id)) {
                return entry;
            }
        }
        return null;
    }

    // Update a diary entry by ID
    public boolean updateEntry(int id, DiaryEntry updatedEntry) {
        for (DiaryEntry entry : entries) {
            if (entry.getId().equals(id)) {
                entry.setTitle(updatedEntry.getTitle());
                entry.setContent(updatedEntry.getContent());
                entry.setDate(updatedEntry.getDate());
                entry.setMood(updatedEntry.getMood());
                return true;
            }
        }
        return false;
    }

    // Delete an entry by ID
    public boolean deleteEntry(int id) {
        for (DiaryEntry entry : entries) {
            if (entry.getId().equals(id)) {
                entries.remove(entry);
                return true;
            }
        }
        return false;
    }
}
