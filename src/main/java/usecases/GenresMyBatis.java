package usecases;

import lombok.Getter;
import lombok.Setter;
import mybatis.dao.GenreMapper;
import mybatis.model.Genre;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Model
public class GenresMyBatis implements Serializable {
    @Inject
    private GenreMapper genreMapper;

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
        this.genreMapper.insert(genreToCreate);
    }

    private void loadAllGenres() {
        this.allGenres = genreMapper.selectAll();
    }
}