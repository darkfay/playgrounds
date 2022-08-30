package com.hotel.sportsplaygrounds.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

import static com.hotel.sportsplaygrounds.model.DbConstants.DB_SCHEMA;

@Getter @Setter
@Entity
@Table(name = "trainers", schema = "my_schema", catalog = "playgrounds")
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trainers_id_seq")
    @SequenceGenerator(name = "trainers_id_seq", schema = DB_SCHEMA, allocationSize = 1)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne()
    @JoinColumn(name = "playground_id")
    private Playground playground;

}
