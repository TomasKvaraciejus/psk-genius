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
        @NamedQuery(name = "Band.findAll", query = "select b from Band as b"),
        @NamedQuery(name = "Band.findByName", query = "select b from Band as b where b.name like :name")
})
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})
},
indexes = {
        @Index(name = "band_name_index", columnList = "name")
})
public class Band implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1)
    @Basic(optional = false)
    private String name;

    @OneToMany(mappedBy = "band",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Song> songs = new ArrayList<>();

    public Band(){}
}