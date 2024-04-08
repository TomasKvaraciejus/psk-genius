package usecases;

import entities.Comment;
import entities.Song;
import lombok.Getter;
import lombok.Setter;
import persistence.CommentDAO;
import persistence.SongDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Model
@SessionScoped
public class SingleSong implements Serializable {
    @Inject
    private SongDAO songDAO;

    @Inject
    private CommentDAO commentDAO;

    @Getter
    private Song song;

    public String songDuration()
    {
        return song.getDuration().toString();
    }

    public String lyrics()
    {
        return song.getLyrics() == null ? "no lyrics yet!" : song.getLyrics();
    }

    @Getter
    @Setter
    private String updatedLyrics;

    @Getter
    private boolean isEditingLyrics = false;

    @Getter
    @Setter
    private String commentToPostUser;

    @Getter
    @Setter
    private String commentToPostContent;

    @Transactional
    public void ToggleIsEditingLyrics()
    {
        if(isEditingLyrics && !updatedLyrics.equals(new String())) {
            this.song.setLyrics(updatedLyrics);
            this.songDAO.update(this.song);
        }

        isEditingLyrics = !isEditingLyrics;
    }

    @Transactional
    public void PostComment()
    {
        Comment comment = new Comment();
        comment.setUser(commentToPostUser);
        comment.setContent(commentToPostContent);

        this.song.getComments().add(comment);
        this.songDAO.update(this.song);
    }

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long songId = Long.parseLong(requestParameters.get("songId"));
        this.song = songDAO.findById(songId);

        updatedLyrics = song.getLyrics() == null ? new String() : song.getLyrics();
    }
}