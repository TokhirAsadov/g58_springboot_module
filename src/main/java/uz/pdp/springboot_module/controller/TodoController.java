package uz.pdp.springboot_module.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.exception.DataNotFoundException;
import uz.pdp.springboot_module.exception.ErrorDto;
import uz.pdp.springboot_module.payload.Todo;
import uz.pdp.springboot_module.payload.TodoCreator;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class TodoController {

    private static AtomicInteger idCounter = new AtomicInteger(0);
    private static List<Todo> todos = new ArrayList<>();

    static {
        todos.add(new Todo(idCounter.incrementAndGet(), "Buy groceries", 1));
        todos.add(new Todo(idCounter.incrementAndGet(), "Finish project", 2));
        todos.add(new Todo(idCounter.incrementAndGet(), "Call mom", 3));
    }

    @GetMapping(value = "/todos"/*, consumes = "application/json", produces = {"application/json", "application/xml"}*/)
    @ResponseBody
    public ResponseEntity<List<Todo>> getTodos() {
        return ResponseEntity.ok(todos);
    }

    // @RequestBody = @ModelAttribute
//    @PostMapping("/todos")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    public void addTodo(@RequestBody TodoCreator creator){
//        Todo todo = new Todo(idCounter.incrementAndGet(), creator.title(), creator.priority());
//        todos.add(todo);
//    }

    @PostMapping("/todos")
    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Todo> addTodo(@RequestBody @Valid TodoCreator creator) {
        Todo todo = new Todo(idCounter.incrementAndGet(), creator.title(), creator.priority());
        todos.add(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }



    @GetMapping(value = "/todos/{id}")
    @ResponseBody
    public ResponseEntity<Todo> getTodoById(@PathVariable Integer id) {
        Optional<Todo> optionalTodo = todos.stream()
                .filter(
                        todo -> todo.id().equals(id)
                ).findFirst();

        if (optionalTodo.isEmpty()) {
            throw new DataNotFoundException("Todo with id " + id + " not found");
        }
        return ResponseEntity.ok(optionalTodo.get());
    }

//    @ExceptionHandler(DataNotFoundException.class)
//    @ResponseBody
//    public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException ex, HttpServletRequest request) {
//        return ResponseEntity
//                .status(HttpStatus.NOT_FOUND)
//                .body(ErrorDto.builder()
//                        .errorCode(404)
//                        .errorMessage(ex.getMessage())
//                        .errorPath(request.getRequestURI())
//                        .build()
//                );
////                .body(Map.of(
////                        "errorCode", 404,
////                        "errorMessage", ex.getMessage(),
////                        "errorPath", request.getRequestURI(),
////                        "timestamp", LocalDateTime.now()
////                ));
//    }
}
