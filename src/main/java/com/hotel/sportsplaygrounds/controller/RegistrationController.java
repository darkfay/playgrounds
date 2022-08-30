//package com.hotel.sportsplaygrounds.controller;
//
//import com.hotel.sportsplaygrounds.model.dto.UserDTO;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.validation.Valid;
//
//@Controller
//@RequestMapping("/registration")
//public class RegistrationController {
//
//    @GetMapping
//    public String newUser(UserDTO userDTO) {
//        return "registration";
//    }
//
//    @PostMapping
//    public String createUser(@Valid UserDTO dto, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
////        long id = userService.save(dto);
////        return "redirect:/home/" + id;
//        return "redirect:/home/";
//    }
//}
