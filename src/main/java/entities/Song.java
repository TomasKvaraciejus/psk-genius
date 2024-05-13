package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.Size;

@Setter
@Getter
@EqualsAndHashCode
@Entity
@NamedQueries({
        @NamedQuery(name = "Song.findAll", query = "select s from Song as s"),
})
public class Song implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;

    @Size(min = 1)
    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private Long duration;

    @Basic
    private String lyrics;

    @ManyToOne(optional = false)
    private Band band;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "song_id")
    private List<Comment> comments = new ArrayList<>();
}
