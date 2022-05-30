package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "trainers", schema = "my_schema", catalog = "playgrounds")
public class Trainer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        TrainersEntity that = (TrainersEntity) o;
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
//        int result = id;
//        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        return result;
//    }
}
