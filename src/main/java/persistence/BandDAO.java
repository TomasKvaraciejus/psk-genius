package persistence;

import entities.Band;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class BandDAO implements IDAO<Band> {

    @Inject
    private EntityManager em;

    public List<Band> findAll() {
        return em.createNamedQuery("Band.findAll", Band.class).getResultList();
    }

    public Band findById(long id) {
        return em.find(Band.class, id);
    }

    public Band findByName(String name) {
        return em.createNamedQuery("Band.findByName", Band.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public void save(Band band) {
        em.persist(band);
    }

    public Band update(Band band) {
        return em.merge(band);
    }

    public void delete(Band band) {
        if (em.contains(band))
            em.remove(band);
    }
}