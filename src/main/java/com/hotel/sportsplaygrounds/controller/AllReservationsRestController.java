//package com.hotel.sportsplaygrounds.controller;
//
//import com.hotel.sportsplaygrounds.model.dto.ReservationDTO;
//import com.hotel.sportsplaygrounds.service.ReservationService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/allReservations")
//@RequiredArgsConstructor
//public class AllReservationsRestController {
//
//    private final ReservationService reservationService;
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public List<ReservationDTO> index(@RequestParam(value = "q", required = false) String query) {
//        if (query == null) {
//            return reservationService.findAll();
//        }
//        return reservationService.findByQuery(query);
//    }
//
//}
