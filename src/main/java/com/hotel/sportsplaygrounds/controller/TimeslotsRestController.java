package com.hotel.sportsplaygrounds.controller;

import com.hotel.sportsplaygrounds.model.Reservation;
import com.hotel.sportsplaygrounds.model.Timeslot;
import com.hotel.sportsplaygrounds.model.dto.TimeslotDTO;
import com.hotel.sportsplaygrounds.service.ReservationService;
import com.hotel.sportsplaygrounds.service.TimeslotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/timeslots")
@RequiredArgsConstructor
public class TimeslotsRestController {

    private final TimeslotService timeslotService;

    private final ReservationService reservationService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TimeslotDTO> index(@RequestParam("playgroundId") Long playgroundId, @RequestParam("date") String dateString) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = simpleDateFormat.parse(dateString);
        List<Reservation> reservations = reservationService.findReservationsByDateAndPlayground(parseDate, playgroundId);
        List<Timeslot> timeslots = timeslotService.findAvailableTimeslots(reservations);
        return timeslots.stream().map(timeslot -> map(timeslot)).collect(Collectors.toList());
    }

    private TimeslotDTO map(Timeslot timeslot){
        TimeslotDTO result = new TimeslotDTO();
        result.setId(timeslot.getId());
        result.setTimeslot(timeslot.getTimeslot());
        return result;
    }


}
