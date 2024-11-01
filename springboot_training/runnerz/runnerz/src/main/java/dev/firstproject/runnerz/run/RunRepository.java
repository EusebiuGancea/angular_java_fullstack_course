package dev.firstproject.runnerz.run;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import java.util.List;

public interface RunRepository extends CrudRepository<Run, Integer> {
    List<Run> findAll();
    List<Run> findAllByLocation(String location);
}
