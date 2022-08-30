package com.hotel.sportsplaygrounds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookingConfirmation")
public class ConfirmationController {

    @GetMapping
    public String index() {
        return "bookingConfirmation";
    }
}
