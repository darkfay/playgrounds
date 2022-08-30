package com.hotel.sportsplaygrounds.service.impl;

import com.hotel.sportsplaygrounds.model.Reservation;
import com.hotel.sportsplaygrounds.model.Timeslot;
import com.hotel.sportsplaygrounds.repo.TimeslotsRepo;
import com.hotel.sportsplaygrounds.service.TimeslotService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TimeslotServiceImpl implements TimeslotService {

    private final ModelMapper modelMapper;
    private final TimeslotsRepo timeslotsRepo;

    @Override
    public List<Timeslot> findAvailableTimeslots(List<Reservation> reservations) {

        List<Timeslot> allTimeslots = (List<Timeslot>) timeslotsRepo.findAll();
        List<Timeslot> takenTimeslots = timeslotsRepo.findTimeslotsByReservationsIn(reservations);
        List<Timeslot> availableTimeslots = new ArrayList<>();

        for (Timeslot timeslot: allTimeslots){
            if (!takenTimeslots.contains(timeslot)){
                availableTimeslots.add(timeslot);
            }
        }

        return availableTimeslots;
    }

    @Override
    public List<Timeslot> findAll(){
        return (List<Timeslot>) timeslotsRepo.findAll();
    }
}
