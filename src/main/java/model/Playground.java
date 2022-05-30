package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
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

    @ManyToMany()
    @JoinColumn()
    private List<Player> players;

    @OneToMany
    @JoinColumn()
    private List<Trainer> trainers;

    @OneToOne
    @JoinColumn()
    private Inventory inventory;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

    @Column(name = "price")
    private Integer price;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PlaygroundsEntity that = (PlaygroundsEntity) o;
//
//        if (id != that.id) return false;
//        if (player != that.player) return false;
//        if (sportsType != null ? !sportsType.equals(that.sportsType) : that.sportsType != null) return false;
//        if (trainer != null ? !trainer.equals(that.trainer) : that.trainer != null) return false;
//        if (inventory != null ? !inventory.equals(that.inventory) : that.inventory != null) return false;
//        if (bookedTime != null ? !bookedTime.equals(that.bookedTime) : that.bookedTime != null) return false;
//        if (price != null ? !price.equals(that.price) : that.price != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (sportsType != null ? sportsType.hashCode() : 0);
//        result = 31 * result + player;
//        result = 31 * result + (trainer != null ? trainer.hashCode() : 0);
//        result = 31 * result + (inventory != null ? inventory.hashCode() : 0);
//        result = 31 * result + (bookedTime != null ? bookedTime.hashCode() : 0);
//        result = 31 * result + (price != null ? price.hashCode() : 0);
//        return result;
//    }
}
