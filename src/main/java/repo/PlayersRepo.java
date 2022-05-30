package repo;

import model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayersRepo extends CrudRepository<Player, Integer> {

    Optional<Player> findPlayerByFirstNameAndLastNameAllIgnoreCase (String firstName, String lastName);

}
