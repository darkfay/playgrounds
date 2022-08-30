package com.hotel.sportsplaygrounds.service.impl;

import com.hotel.sportsplaygrounds.model.Playground;
import com.hotel.sportsplaygrounds.model.Trainer;
import com.hotel.sportsplaygrounds.model.dto.PlaygroundDTO;
import com.hotel.sportsplaygrounds.repo.TrainersRepo;
import com.hotel.sportsplaygrounds.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrainerServiceImpl implements TrainerService {

    private final TrainersRepo trainersRepo;

    private final ModelMapper modelMapper;

    @Override
    public List<Trainer> findAll() {

        return (List<Trainer>) trainersRepo.findAll();
    }

    @Override
    public List<Trainer> findTrainerByPlayground(Long playgroundId) {

        return trainersRepo.findByPlaygroundId(playgroundId);
    }

    private Playground map(PlaygroundDTO playgroundDTO) {
        return modelMapper.map(playgroundDTO, Playground.class);
    }
}
