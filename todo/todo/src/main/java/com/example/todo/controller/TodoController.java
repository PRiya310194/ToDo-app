package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// annotation is controller
// controller-to send the output in this class
// create todo, delete todo, update, fetch(crud opertion)
@RestController
@RequestMapping("/api/v1/todo-app")
public class TodoController {
    @Autowired           // dependency injection
    private  TodoService todoService;                           // http://localhost:8080/api/v1/todo-app/find-all
    //public TodoController(TodoService todoService){

        //this.todoService=todoService;
    //}
                                                             // http://localhost:8080/api/v1/todo-app/add-todo(postman)
    @PostMapping("/add-todo")                // http://localhost:8080/api/v1/todo-app/find-all- to see the added json from postman
    public void addTodo(@RequestBody Todo todo){

        todoService.addTodo(todo);
}
@GetMapping("/find-todo/id/{id}")                         // http://localhost:8080/api/v1/todo-app/find-todo/id/5
//@RequestMapping("/find-todo/id/{id}")
    public Todo findTodoById(@PathVariable int id){
        return todoService.findById(id);
}
@GetMapping("find-all")
    public List<Todo> findAllTodo(){   // controller is talking to the service layer
    return todoService.findAll();

}
@PutMapping("/update-todo/id/{id}")
    public void updateTodo(@PathVariable int id, @RequestBody Todo todo){
todoService.updateTodo(id,todo);
}
@DeleteMapping("delete-todo/id/{id}")

    public ResponseEntity<Todo>deleteTodo(@PathVariable int id){
todoService.deleteTodo(id);
return new ResponseEntity<>(HttpStatus.NOT_FOUND);  //200
}
}





