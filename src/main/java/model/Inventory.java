package model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "inventory", schema = "my_schema", catalog = "playgrounds")
public class Inventory {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn()
    private Playground playground;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        InventoryEntity that = (InventoryEntity) o;
//
//        if (id != that.id) return false;
//        if (inventoryType != null ? !inventoryType.equals(that.inventoryType) : that.inventoryType != null)
//            return false;
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = id;
//        result = 31 * result + (inventoryType != null ? inventoryType.hashCode() : 0);
//        return result;
//    }
}
