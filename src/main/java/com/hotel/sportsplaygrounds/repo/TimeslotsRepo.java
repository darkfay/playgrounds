package com.hotel.sportsplaygrounds.repo;

import com.hotel.sportsplaygrounds.model.Reservation;
import com.hotel.sportsplaygrounds.model.Timeslot;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TimeslotsRepo extends CrudRepository<Timeslot, Long> {

    List<Timeslot> findTimeslotsByReservationsIn(List<Reservation> reservations);
}
