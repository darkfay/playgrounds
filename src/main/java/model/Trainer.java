package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "trainers", schema = "my_schema", catalog = "playgrounds")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playgrounds_id_seq")
    @SequenceGenerator(name = "playgrounds_id_seq", schema = "my_schema", allocationSize = 1)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToOne()
    @JoinColumn(name = "playground")
    private Playground playground;

}
