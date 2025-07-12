package com.codewithudo.musicalbummanager.service;

import com.codewithudo.musicalbummanager.model.Album;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumService {

    private final List<Album> albums = new ArrayList<>();
    private int nextId = 1;

    // Add a new album
    public boolean addAlbum(Album album) {
        album.setId(nextId++);
        albums.add(album);
        return true;
    }

    // Get all albums
    public List<Album> getAllAlbums() {
        return albums;
    }

    // Get album by ID
    public Album getAlbumById(int id) {
        for (Album album : albums) {
            if (album.getId().equals(id)) {
                return album;
            }
        }
        return null;
    }

    // Update an album by ID
    public boolean updateAlbum(int id, Album updatedAlbum) {
        for (Album album : albums) {
            if (album.getId().equals(id)) {
                album.setTitle(updatedAlbum.getTitle());
                album.setArtist(updatedAlbum.getArtist());
                album.setReleaseYear(updatedAlbum.getReleaseYear());
                album.setGenre(updatedAlbum.getGenre());
                return true;
            }
        }
        return false;
    }

    // Delete an album by ID
    public boolean deleteAlbumById(int id) {
        return albums.removeIf(album -> album.getId() == id);
    }
}
