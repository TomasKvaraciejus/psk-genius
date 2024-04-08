package persistence;

import entities.Comment;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CommentDAO implements IDAO<Comment> {

    @Inject
    private EntityManager em;

    public List<Comment> findAll() {
        return em.createNamedQuery("Comment.findAll", Comment.class).getResultList();
    }

    public Comment findById(long id) {
        return em.find(Comment.class, id);
    }

    public void save(Comment comment) {
        em.persist(comment);
    }

    public Comment update(Comment comment) {
        return em.merge(comment);
    }

    public void delete(Comment comment) {
        if (em.contains(comment))
            em.remove(comment);
    }
}