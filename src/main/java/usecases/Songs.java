package usecases;

import entities.Band;
import entities.Song;
import entities.Genre;
import lombok.Getter;
import lombok.Setter;
import persistence.BandDAO;
import persistence.GenreDAO;
import persistence.SongDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Model
public class Songs implements Serializable {
    @Inject
    private SongDAO songDAO;

    @Inject
    private BandDAO bandDAO;

    @Inject
    private GenreDAO genreDAO;

    @Getter
    @Setter
    private Song songToCreate = new Song();

    @Getter
    private List<Song> allSongs;

    @PostConstruct
    public void init() {
        loadAllSongs();
    }

    @Getter
    @Setter
    private String songBandName;

    @Getter
    @Setter
    private List<Long> songGenres = new ArrayList<>();

    @Transactional
    public void createSong() {
        Band band = bandDAO.findByName(songBandName);
        songToCreate.setBand(band);

        List<Genre> genres = new ArrayList<>();
        for(long genreId : songGenres) {
            genres.add(genreDAO.findById(genreId));
        }
        songToCreate.setGenres(genres);

        this.songDAO.save(songToCreate);
    }

    private void loadAllSongs() {
        this.allSongs = songDAO.findAll();
    }
}