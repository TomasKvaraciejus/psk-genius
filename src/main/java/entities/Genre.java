package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Size;

@Setter
@Getter
@Entity
@EqualsAndHashCode
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
})
@NamedQueries({
        @NamedQuery(name = "Genre.findAll", query = "select b from Genre as b"),
})
public class Genre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1)
    @Basic(optional = false)
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs = new ArrayList<>();
}
