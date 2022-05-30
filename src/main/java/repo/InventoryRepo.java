package repo;

import model.Inventory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface InventoryRepo extends CrudRepository<Inventory, Integer> {

    Optional<Inventory> findInventoryByPlayground (String playground);

}
