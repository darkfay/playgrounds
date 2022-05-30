package repo;

import model.Trainer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TrainersRepo extends CrudRepository<Trainer, Integer> {

    Optional<Trainer> findTrainerByFirstNameAndLastNameAllIgnoreCase (String firstName, String lastName);
}
