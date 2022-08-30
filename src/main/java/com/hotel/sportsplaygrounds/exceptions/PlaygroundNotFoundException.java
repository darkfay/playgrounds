package com.hotel.sportsplaygrounds.exceptions;

import lombok.Value;

@Value
public class PlaygroundNotFoundException extends RuntimeException {

    Long id;
}
