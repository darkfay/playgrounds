package com.hotel.sportsplaygrounds.model.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Data
public class ReservationDTO {


    private String playgroundType;

    @NotNull
    private Long playgroundId;

    @NotBlank
    private String date = String.valueOf(new Date());

    @NotNull
    private Long timeslotId;

    private String timeslot;

    private Long trainerId;

    private String trainerFirstName;

    private String trainerLastName;

    private String playerFirstName;

    private String playerLastName;

    private boolean inventory;

    private Long playerId;

    private int roomNr;

}
