package com.hotel.sportsplaygrounds.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static com.hotel.sportsplaygrounds.model.DbConstants.DB_SCHEMA;

@Getter
@Setter
@Entity
@Table(name = "timeslots", schema = DB_SCHEMA, catalog = "playgrounds")
public class Timeslot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeslots_id_seq")
    @SequenceGenerator(name = "timeslots_id_seq", schema = DB_SCHEMA, allocationSize = 1)
    private Long id;

    @Column(name = "timeslot")
    private String timeslot;

    @OneToMany(mappedBy = "timeslot", cascade = {CascadeType.ALL})
    private List<Reservation> reservations;

}
