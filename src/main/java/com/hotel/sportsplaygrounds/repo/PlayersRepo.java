package com.hotel.sportsplaygrounds.repo;

import com.hotel.sportsplaygrounds.model.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlayersRepo extends CrudRepository<Player, Long> {

    Optional<Player> findPlayerByFirstNameAndLastNameAllIgnoreCase (String firstName, String lastName);

}
