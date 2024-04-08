package persistence;

import entities.Genre;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class GenreDAO implements IDAO<Genre> {

    @Inject
    private EntityManager em;

    public List<Genre> findAll() {
        return em.createNamedQuery("Genre.findAll", Genre.class).getResultList();
    }

    public Genre findById(long id) {
        return em.find(Genre.class, id);
    }

    public void save(Genre genre) {
        em.persist(genre);
    }

    public Genre update(Genre genre) {
        return em.merge(genre);
    }

    public void delete(Genre genre) {
        if (em.contains(genre))
            em.remove(genre);
    }
}