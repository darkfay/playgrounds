package com.hotel.sportsplaygrounds.repo;

import com.hotel.sportsplaygrounds.model.Trainer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TrainersRepo extends CrudRepository<Trainer, Long> {

    @Query("SELECT T from Trainer T WHERE T.playground.id=:id")
    List<Trainer> findByPlaygroundId(@Param("id") Long playgroundId);
}
