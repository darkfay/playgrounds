package repo;

import model.Player;
import model.Playground;
import org.springframework.data.repository.CrudRepository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PlaygroundsRepo extends CrudRepository<Playground, Integer> {

    Optional<Playground> findPlaygroundBySportsType (String sportsType);

    List<LocalTime> findAvailableTimeslotsByDate(LocalDate date);

    // available for admin only
    Map<Player,Time> findScheduleByDate(LocalDate date);


}
