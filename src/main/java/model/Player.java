package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "players", schema = "my_schema", catalog = "playgrounds")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Player {
    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @ManyToMany()
    @JoinColumn()
    private List<Playground> playgrounds;


//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        PlayersEntity that = (PlayersEntity) o;
//
//        if (id != that.id) return false;
//        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
//        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = firstName != null ? firstName.hashCode() : 0;
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        result = 31 * result + id;
//        return result;
//    }
}
