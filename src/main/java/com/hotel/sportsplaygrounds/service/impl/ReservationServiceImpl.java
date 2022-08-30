package com.hotel.sportsplaygrounds.service.impl;

import com.hotel.sportsplaygrounds.model.*;
import com.hotel.sportsplaygrounds.model.dto.ReservationDTO;
import com.hotel.sportsplaygrounds.repo.*;
import com.hotel.sportsplaygrounds.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.LazyToOne;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.Streamable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final UsersRepo usersRepo;
    private final TrainersRepo trainersRepo;
    private final PlaygroundRepo playgroundRepo;
    private final TimeslotsRepo timeslotsRepo;
    private final ReservationRepo reservationRepo;

    private static SimpleDateFormat DATE_FORMAT;

    private final PlayersRepo playersRepo;


    private final ModelMapper modelMapper;

    @Override
    public Optional<ReservationDTO> findReservationById(Long id) {
        return reservationRepo.findById(id).map(this::map);
    }

    @Override
    public List<ReservationDTO> findAll() {
        return Streamable.of(reservationRepo.findAll()).map(entity -> map(entity)).toList();
    }

    @Override
    public Long cancelReservation(Long id) {
        return null;
    }

//    @Override
//    public List<ReservationDTO> findByQuery(String query) {
//        return reservationRepo.findByQuery(query).stream().map(entity -> map(entity)).collect(Collectors.toList());
//    }

    @Override
    public List<ReservationDTO> findReservationsByUser() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails) auth.getPrincipal()).getUsername();

        Optional<User> currentUser = usersRepo.findByEmail(email);

        List<Reservation> reservations = reservationRepo.findReservationsByUser(currentUser);
        return reservations.stream().map(entity -> map(entity)).collect(Collectors.toList());
    }

    ;

    @Override
    @Transactional
    public Long save(ReservationDTO reservationDTO) throws ParseException {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        String email = ((UserDetails) auth.getPrincipal()).getUsername();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parseDate = simpleDateFormat.parse(reservationDTO.getDate());

        Optional<User> currentUser = usersRepo.findByEmail(email);
        Optional<Trainer> trainer = trainersRepo.findById(reservationDTO.getTrainerId());
        Optional<Playground> playground = playgroundRepo.findPlaygroundById(reservationDTO.getPlaygroundId());
        Optional<Timeslot> timeslot = timeslotsRepo.findById(reservationDTO.getTimeslotId());
        Optional<Player> player = playersRepo.findById(currentUser.get().getPlayer().getId());

        long id = currentUser.map(user -> {
                    Reservation reservation = new Reservation();
                    reservation.setUser(user);
                    reservation.setPlayground(playground.get());
                    reservation.setPlayer(player.get());
                    reservation.setDate(parseDate);
                    reservation.setTimeslot(timeslot.get());
                    reservation.setTrainer(trainer.get());
                    reservation.setInventory(reservationDTO.isInventory());
                    reservation.setCreatedBy(user);
                    reservation.setCreatedAt(new Date());

                    reservation = reservationRepo.save(reservation);
                    return reservation.getId();
                }
        ).orElseThrow(() -> new UsernameNotFoundException(email));

        return id;
    }

    @Override
    public List<Reservation> findReservationsByDateAndPlayground(Date date, Long playgroundId) throws ParseException {

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date parseDate = simpleDateFormat.parse(reservationDTO.getDate());
//        Optional<Playground> playground = playgroundRepo.findPlaygroundById(reservationDTO.getPlaygroundId());
        List<Reservation> reservations = reservationRepo.findReservationsByDateAndPlaygroundId(date, playgroundId);
        return reservations;
    }


    private ReservationDTO map(Reservation reservation) {
        return modelMapper.map(reservation, ReservationDTO.class);
    }
}
