package usecases;

import entities.Genre;
import lombok.Getter;
import lombok.Setter;
import persistence.GenreDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class Genres implements Serializable {
    @Inject
    private GenreDAO genreDAO;

    @Getter
    @Setter
    private Genre genreToCreate = new Genre();

    @Getter
    private List<Genre> allGenres;

    @PostConstruct
    public void init() {
        loadAllGenres();
    }

    @Transactional
    public void createGenre() {
        this.genreDAO.save(genreToCreate);
    }

    private void loadAllGenres() {
        this.allGenres = genreDAO.findAll();
    }
}