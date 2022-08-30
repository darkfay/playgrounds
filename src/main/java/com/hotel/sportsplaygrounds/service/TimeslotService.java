package com.hotel.sportsplaygrounds.service;

import com.hotel.sportsplaygrounds.model.Reservation;
import com.hotel.sportsplaygrounds.model.Timeslot;

import java.util.List;

public interface TimeslotService {

    List<Timeslot> findAvailableTimeslots(List<Reservation> reservations);

    List<Timeslot> findAll();
}
