package com.hotel.sportsplaygrounds.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import static com.hotel.sportsplaygrounds.model.DbConstants.DB_SCHEMA;

@Getter @Setter
@Entity
@Table(name = "playgrounds", schema = "my_schema", catalog = "playgrounds")
public class Playground {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playgrounds_id_seq")
    @SequenceGenerator(name = "playgrounds_id_seq", schema = DB_SCHEMA, allocationSize = 1)
    private Long id;

    @Column(name = "sports_type")
    private String sportsType;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "playgrounds_players", schema = "my_schema",
//            joinColumns = @JoinColumn(name = "playground_id"),
//            inverseJoinColumns = @JoinColumn(name = "player_id")
//    )
//    private List<Player> players = new ArrayList<>();

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "playground", cascade = {CascadeType.ALL})
    private List<Trainer> trainers;



}
