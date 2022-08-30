package com.hotel.sportsplaygrounds.repo;

import com.hotel.sportsplaygrounds.model.Playground;
import com.hotel.sportsplaygrounds.model.Trainer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlaygroundRepo extends CrudRepository<Playground, Long> {

    Optional<Playground> findPlaygroundById(Long id);
}
