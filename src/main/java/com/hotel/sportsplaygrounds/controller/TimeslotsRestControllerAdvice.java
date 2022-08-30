package com.hotel.sportsplaygrounds.controller;

import com.hotel.sportsplaygrounds.exceptions.PlaygroundNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TimeslotsRestControllerAdvice {

    @ExceptionHandler(PlaygroundNotFoundException.class)
    public String handlePlaygroundNotFound(PlaygroundNotFoundException e, Model model) {
        model.addAttribute("id", e.getId());
        return "notFound";
    }
}
