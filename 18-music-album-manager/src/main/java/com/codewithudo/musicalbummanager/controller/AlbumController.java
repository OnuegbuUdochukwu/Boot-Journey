package com.codewithudo.musicalbummanager.controller;

import com.codewithudo.musicalbummanager.model.Album;
import com.codewithudo.musicalbummanager.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    // Add new album
    @PostMapping
    public ResponseEntity<String> addAlbum(@RequestBody Album album) {
        boolean added = albumService.addAlbum(album);
        if (added) {
            return new ResponseEntity<>("Album added successfully.", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Failed to add album.", HttpStatus.BAD_REQUEST);
    }

    // Get all albums
    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumService.getAllAlbums(), HttpStatus.OK);
    }

    // Get album by ID
    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable int id) {
        Album album = albumService.getAlbumById(id);
        if (album != null) {
            return new ResponseEntity<>(album, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Update album by ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateAlbum(@PathVariable int id, @RequestBody Album album) {
        boolean updated = albumService.updateAlbum(id, album);
        if (updated) {
            return new ResponseEntity<>("Album updated successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Album not found.", HttpStatus.NOT_FOUND);
    }

    // Delete album by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlbum(@PathVariable int id) {
        boolean deleted = albumService.deleteAlbumById(id);
        if (deleted) {
            return new ResponseEntity<>("Album deleted successfully.", HttpStatus.OK);
        }
        return new ResponseEntity<>("Album not found.", HttpStatus.NOT_FOUND);
    }
}
