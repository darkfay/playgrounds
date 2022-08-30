package com.hotel.sportsplaygrounds.controller;

import com.hotel.sportsplaygrounds.model.Playground;
import com.hotel.sportsplaygrounds.model.Timeslot;
import com.hotel.sportsplaygrounds.model.Trainer;
import com.hotel.sportsplaygrounds.model.dto.ReservationDTO;
import com.hotel.sportsplaygrounds.service.PlaygroundService;
import com.hotel.sportsplaygrounds.service.ReservationService;
import com.hotel.sportsplaygrounds.service.TimeslotService;
import com.hotel.sportsplaygrounds.service.TrainerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ReservePlaygroundController {

    private final PlaygroundService playgroundService;

    private final ReservationService reservationService;

    private final TrainerService trainerService;

    private final TimeslotService timeslotService;

    @GetMapping
    public String index(Model model) {
        List<Playground> playgrounds = playgroundService.findAll();
        String date = String.valueOf(new Date());
//        List<Trainer> trainers = trainerService.findAll();
//        List<Trainer> trainers = trainerService.findTrainerByPlayground();
//        List<Timeslot> timeslots = timeslotService.findAll();
//        List<Timeslot> timeslots = timeslotService.findAvailableTimeslots();
        ReservationDTO reservationDTO = new ReservationDTO();
        model.addAttribute("playgrounds", playgrounds);
//        model.addAttribute("trainers", trainers);
//        model.addAttribute("timeslots", timeslots);
        model.addAttribute("reservationDTO", reservationDTO);
        model.addAttribute("date", date);
        return "playgroundDTO";
    }


    @PostMapping
    public String saveReservation(@Valid ReservationDTO dto, BindingResult bindingResult) throws ParseException {
        if (bindingResult.hasErrors()) {
            return "playgroundDTO";
        }
        reservationService.save(dto);
        return "redirect:/bookingConfirmation";
    }

}
