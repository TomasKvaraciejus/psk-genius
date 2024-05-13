package services;

import entities.Song;

import java.util.List;

public interface SongFilter {
    List<Song> filterSongs(List<Song> allSongs, List<Long> genreIds, Long bandId);
}