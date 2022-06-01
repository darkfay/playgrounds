package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "players", schema = "my_schema", catalog = "playgrounds")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playgrounds_id_seq")
    @SequenceGenerator(name = "playgrounds_id_seq", schema = "my_schema", allocationSize = 1)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @ManyToMany(mappedBy = "players")
    private List<Playground> playgrounds = new ArrayList<>();

}
