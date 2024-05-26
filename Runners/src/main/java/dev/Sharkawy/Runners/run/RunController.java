package dev.Sharkawy.Runners.run;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/run")
public class RunController  {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping("")
    List<Run>  findall(){

        return runRepository.findall();
    }
    @GetMapping("/{id}")
    Run findbyid(@PathVariable Integer id) {

    Optional<Run> run = runRepository.findbyid(id);
    if(run.isEmpty()) {
        throw new RunNotFoundExeption();
    }
    else {
        return run.get();
    }


    }
@ResponseStatus(HttpStatus.CREATED)
@PostMapping("")
void create(@Valid @RequestBody Run run) {
        runRepository.create(run);
}
@ResponseStatus(HttpStatus.NO_CONTENT)
@PutMapping("/{id}")
    void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
    runRepository.update(run, id);

}
@ResponseStatus(HttpStatus.NO_CONTENT)
@DeleteMapping("/{id}")
void delete(@PathVariable Integer id) {
        runRepository.delete(id);
}
}







