package com.hotel.sportsplaygrounds.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {

    @NotBlank
    String email;

    @NotBlank
    String password;

    @NotBlank
    String username;

    @NotBlank
    String roomNr;

}
