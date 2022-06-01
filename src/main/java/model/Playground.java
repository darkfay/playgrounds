package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
@Table(name = "playgrounds", schema = "my_schema", catalog = "playgrounds")
public class Playground {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "sportsType")
    private String sportsType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "playgrounds_players", schema = "my_schema",
            joinColumns = @JoinColumn(name = "playground_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id")
    )
    private List<Player> players = new ArrayList<>();

    @OneToMany(mappedBy = "playground")
    private List<Trainer> trainers;

    @Column(name = "inventory")
    private boolean inventory;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "price")
    private Integer price;

}
