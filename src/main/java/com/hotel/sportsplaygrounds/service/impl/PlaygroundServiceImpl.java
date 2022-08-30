package com.hotel.sportsplaygrounds.service.impl;

import com.hotel.sportsplaygrounds.model.Playground;
import com.hotel.sportsplaygrounds.model.Reservation;
import com.hotel.sportsplaygrounds.model.dto.ReservationDTO;
import com.hotel.sportsplaygrounds.repo.PlaygroundRepo;
import com.hotel.sportsplaygrounds.service.PlaygroundService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PlaygroundServiceImpl implements PlaygroundService {

    private  final PlaygroundRepo playgroundRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<Playground> findAll() {
        return Streamable.of(playgroundRepo.findAll()).map(entity -> map(entity)).toList();
    }

    private Playground map(Playground playground) {
        return modelMapper.map(playground, Playground.class);
    }
}
