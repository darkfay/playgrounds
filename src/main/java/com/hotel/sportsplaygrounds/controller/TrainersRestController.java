package com.hotel.sportsplaygrounds.controller;

import com.hotel.sportsplaygrounds.model.Trainer;
import com.hotel.sportsplaygrounds.model.dto.PlaygroundDTO;
import com.hotel.sportsplaygrounds.model.dto.TrainerDTO;
import com.hotel.sportsplaygrounds.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/trainers")
@RequiredArgsConstructor
public class TrainersRestController {

    private final TrainerService trainerService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TrainerDTO> index(@RequestParam("playgroundId") Long playgroundId) {
        List<Trainer> trainers = trainerService.findTrainerByPlayground(playgroundId);
        return trainers.stream().map(trainer -> map(trainer)).collect(Collectors.toList());
    }

    private TrainerDTO map(Trainer trainer){
        TrainerDTO result = new TrainerDTO();
        result.setId(trainer.getId());
        result.setName(trainer.getFirstName() + " " + trainer.getLastName());
        return result;
    }
}
