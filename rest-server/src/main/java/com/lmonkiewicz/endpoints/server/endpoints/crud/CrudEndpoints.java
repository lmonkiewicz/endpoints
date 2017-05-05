package com.lmonkiewicz.endpoints.server.endpoints.crud;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.*;

/**
 * Created by lmonkiewicz on 05.05.2017.
 */
@RestController
@RequestMapping("/crud")
class CrudEndpoints {

    private final Map<Long, Task> tasks = new LinkedHashMap<>();
    private static Long idGenerator = 1L;


    @GetMapping("/tasks")
    List<Task> list(){
        return new ArrayList<>(tasks.values());
    }

    @GetMapping("/tasks/{id}")
    Task get(@PathVariable Long id) {
        return Optional.ofNullable(tasks.get(id))
                .orElseThrow(TaskNotFoundException::new);
    }

    @PutMapping("/tasks")
    ResponseEntity create(@Valid @RequestBody Task task) {
        final Long id = idGenerator++;
        task.setId(id);

        tasks.putIfAbsent(id, task);
        return ResponseEntity.created(URI.create("/crud/tasks/" + id)).build();
    }

    @PostMapping("/tasks/{id}")
    ResponseEntity update(@PathVariable Long id, @Valid @RequestBody Task task) {
        if (!tasks.containsKey(id)){
            throw new TaskNotFoundException();
        }
        task.setId(id);
        tasks.put(id, task);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/tasks/{id}")
    ResponseEntity delete(@PathVariable Long id){
        if (!tasks.containsKey(id)){
            throw new TaskNotFoundException();
        }
        tasks.remove(id);

        return ResponseEntity.ok().build();
    }





    @ExceptionHandler
    ResponseEntity handleTaskNotFoundException(TaskNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
