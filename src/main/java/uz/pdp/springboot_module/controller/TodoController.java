package uz.pdp.springboot_module.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.pdp.springboot_module.payload.Todo;
import uz.pdp.springboot_module.payload.TodoCreator;

import java.util.ArrayList;
import java.util.List;
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

    @GetMapping(value = "/todos", /*consumes = "application/json", */produces = {"application/json", "application/xml"})
    @ResponseBody
    public ResponseEntity<List<Todo>> getTodos(){
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
    public ResponseEntity<Todo> addTodo(@RequestBody TodoCreator creator){
        Todo todo = new Todo(idCounter.incrementAndGet(), creator.title(), creator.priority());
        todos.add(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(todo);
    }
}
