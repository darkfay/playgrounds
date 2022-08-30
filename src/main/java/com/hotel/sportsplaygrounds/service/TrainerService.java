package com.hotel.sportsplaygrounds.service;

import com.hotel.sportsplaygrounds.model.Playground;
import com.hotel.sportsplaygrounds.model.Trainer;
import com.hotel.sportsplaygrounds.model.dto.PlaygroundDTO;
import com.hotel.sportsplaygrounds.model.dto.ReservationDTO;

import java.util.List;

public interface TrainerService {

    List<Trainer> findAll();

    List<Trainer> findTrainerByPlayground(Long playgroundId);
}
