package com.example.geniusgeniusgenius.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import javax.validation.constraints.Size;

@Setter
@Getter
@EqualsAndHashCode
@Entity
public class Song implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1)
    @Basic(optional = false)
    private String name;

    @ManyToOne(optional = false)
    private Band band;

    @ManyToMany(mappedBy = "songs", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Genre> genres = new HashSet<>();

    @OneToMany
    private Set<Song> song = new HashSet<>();
}
