package entities;

import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.Size;

@Setter
@Getter
@EqualsAndHashCode
@Entity
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 1)
    @Basic(optional = false)
    private String user;

    @Size(min = 1)
    @Basic(optional = false)
    private String content;
}
