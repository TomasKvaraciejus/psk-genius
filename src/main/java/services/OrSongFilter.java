package services;

import entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@ApplicationScoped
@Alternative
public class OrSongFilter implements SongFilter {
    @Override
    public List<Song> filterSongs(List<Song> allSongs, List<Long> genreIds, Long bandId) {
        if (bandId == null && genreIds.isEmpty()) return allSongs;
        return allSongs.stream()
                .filter(song -> (song.getBand().getId().equals(bandId) || (genreIds.isEmpty() || containsOne(song, genreIds))))
                .collect(Collectors.toList());
    }

    boolean containsOne(Song song, List<Long> genreIds){
        Set<Long> songGenres = song.getGenres().stream().map(g -> g.getId()).collect(Collectors.toSet());
        return songGenres.stream().anyMatch(g -> genreIds.contains(g));
    }
}