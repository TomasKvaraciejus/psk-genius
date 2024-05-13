package persistence;

import entities.Song;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SongDAO implements IDAO<Song> {

    @Inject
    private EntityManager em;

    public List<Song> findAll() {
        return em.createNamedQuery("Song.findAll", Song.class).getResultList();
    }

    @Transactional
    public Song findById(long id) {
        return em.find(Song.class, id);
    }

    public void save(Song song) {
        em.persist(song);
    }

    public Song update(Song song) {
        return em.merge(song);
    }

    public void delete(Song song) {
        if (em.contains(song))
            em.remove(song);
    }
}