package dev.firstproject.runnerz.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// RestController - "I am a class that responds to requests, returns req"
@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final RunRepository runRepository;

    public RunController (RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    //get all
    @GetMapping()
    List<Run> findAll() {
        return runRepository.findAll();
    }

    //get by id
    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {

        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    void create(@Valid @RequestBody Run run) {
        runRepository.save(run);
    }

    //put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping ("/{id}")
    void update(@Valid  @RequestBody Run run, @PathVariable Integer id) {
        runRepository.save(run);
    }
    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        var run = runRepository.findById(id)
                .orElseThrow(RunNotFoundException::new); // Throw custom exception if not found
        runRepository.delete(run);
    }


    @GetMapping("/location/{location}")
    List<Run> findByLocation(@PathVariable String location) {
        return runRepository.findAllByLocation(location);
    }
}
