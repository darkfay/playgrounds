package com.hotel.sportsplaygrounds.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import static com.hotel.sportsplaygrounds.model.DbConstants.DB_SCHEMA;

@Getter
@Setter
@Entity
@Table(name = "reservations", schema = DB_SCHEMA, catalog = "playgrounds")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reservations_id_seq")
    @SequenceGenerator(name = "reservations_id_seq", schema = DB_SCHEMA, allocationSize = 1)
    private Long id;
//
//    @Column(name = "status")
//    private String status;

    @Column(name = "inventory")
    private boolean inventory;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "timeslot_id")
    private Timeslot timeslot;

    @Column(name = "price")
    private Integer price;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "playground_id")
    private Playground playground;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

}
