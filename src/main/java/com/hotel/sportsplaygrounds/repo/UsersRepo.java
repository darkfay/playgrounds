package com.hotel.sportsplaygrounds.repo;

import com.hotel.sportsplaygrounds.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsersRepo extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);


}
