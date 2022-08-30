package com.hotel.sportsplaygrounds.repo;

import com.hotel.sportsplaygrounds.model.Playground;
import com.hotel.sportsplaygrounds.model.Reservation;
import com.hotel.sportsplaygrounds.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Streamable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

public interface ReservationRepo extends CrudRepository<Reservation, Long> {


    List<Reservation> findReservationsByDateAndPlayground(Date date, Optional<Playground> playground);

    @Query("SELECT R FROM Reservation R WHERE R.date=:date AND R.playground.id=:id")
    List<Reservation> findReservationsByDateAndPlaygroundId(@Param("date") Date date, @Param("id") Long playgroundId);

    void deleteReservationById(Long id);

    List<Reservation> findReservationsByUser(Optional<User> user);


//    Streamable<Object> findByQuery(String query);
}
