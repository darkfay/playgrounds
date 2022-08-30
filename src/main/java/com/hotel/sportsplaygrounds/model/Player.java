package com.hotel.sportsplaygrounds.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.hotel.sportsplaygrounds.model.DbConstants.DB_SCHEMA;

@Getter @Setter
@Entity
@Table(name = "players", schema = "my_schema", catalog = "playgrounds")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "playgrounds_id_seq")
    @SequenceGenerator(name = "playgrounds_id_seq", schema = DB_SCHEMA, allocationSize = 1)
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "room_number")
    private int roomNumber;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToMany(mappedBy = "player", cascade = {CascadeType.ALL})
    private List<Reservation> reservations = new ArrayList<>();

    @OneToOne
    private User createdBy;

}
