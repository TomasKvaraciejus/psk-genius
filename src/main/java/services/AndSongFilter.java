package services;

import entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
@Alternative
public class AndSongFilter implements SongFilter {
    @Override
    public List<Song> filterSongs(List<Song> allSongs, List<Long> genreIds, Long bandId) {
        return allSongs.stream()
                .filter(song -> (bandId == null || song.getBand().getId().equals(bandId)))
                .filter(song -> (genreIds.isEmpty() || containsAll(song, genreIds)))
                .collect(Collectors.toList());
    }

    boolean containsAll(Song song, List<Long> genreIds){
        Set<Long> songGenres = song.getGenres().stream().map(g -> g.getId()).collect(Collectors.toSet());
        return songGenres.containsAll(genreIds);
    }
}