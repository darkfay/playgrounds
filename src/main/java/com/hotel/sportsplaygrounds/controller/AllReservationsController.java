package com.hotel.sportsplaygrounds.controller;

import com.hotel.sportsplaygrounds.model.Playground;
import com.hotel.sportsplaygrounds.model.Timeslot;
import com.hotel.sportsplaygrounds.model.Trainer;
import com.hotel.sportsplaygrounds.model.dto.ReservationDTO;
import com.hotel.sportsplaygrounds.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/allReservations")
@RequiredArgsConstructor
public class AllReservationsController {

    private final ReservationService reservationService;

    @GetMapping
//    @RolesAllowed("ADMIN")
    public String index(Model model) {
        List<ReservationDTO> reservations = reservationService.findAll();
        model.addAttribute("reservations", reservations);
        return "allReservationsDTO";
    }

}
