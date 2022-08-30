package com.hotel.sportsplaygrounds.service;

import com.hotel.sportsplaygrounds.model.Reservation;
import com.hotel.sportsplaygrounds.model.User;
import com.hotel.sportsplaygrounds.model.dto.ReservationDTO;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Long save(ReservationDTO reservationDTO) throws ParseException;

    Optional<ReservationDTO> findReservationById(Long id);

    List<ReservationDTO> findAll();

    List<Reservation> findReservationsByDateAndPlayground(Date date, Long playgroundId) throws ParseException;

    List<ReservationDTO> findReservationsByUser();


    Long cancelReservation(Long id);

//    List<ReservationDTO> findByQuery(String query);
}

