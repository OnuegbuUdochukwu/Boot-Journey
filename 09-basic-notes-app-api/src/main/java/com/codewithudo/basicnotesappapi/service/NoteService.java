package com.codewithudo.basicnotesappapi.service;

import com.codewithudo.basicnotesappapi.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NoteService {

    private ArrayList<Note> notes = new ArrayList<>();
    private int numberOfNotes = 1;

//    public NoteService(ArrayList<Note> notes) {
//        this.notes = notes;
//        this.numberOfNotes = notes.size();
//    }

    public ArrayList<Note> getAllNotes(){
        return notes;
    }

    public Note getNoteById(int id){
        for (Note note : notes) {
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }

    public boolean addNote(Note note) {
        numberOfNotes++;
        return notes.add(note);
    }

    public boolean updateNote(int id, Note note) {
        for(Note n : notes) {
            if(n.getId() == id){
                note.setTitle(note.getTitle());
                note.setContent(note.getContent());
                return true;
            }
        }
        return false;
    }

    public boolean removeNote(Note note) {
        numberOfNotes--;
        return notes.remove(note);
    }
}
