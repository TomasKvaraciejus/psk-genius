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
        @NamedQuery(name = "Song.findAll", query = "select b from Song as b"),
})
public class Song implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1)
    @Basic(optional = false)
    private String name;

    @ManyToOne(optional = false)
    private Band band;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Genre> genres = new ArrayList<>();
}
