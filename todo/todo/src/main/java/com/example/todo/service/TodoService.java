package com.example.todo.service;

import com.example.todo.model.Todo;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;


@Service

public class TodoService {
    private static List<Todo>todos=new ArrayList<>();   // in memory database
    private static int todoCount=0;
            static {
                todos.add(new Todo(++todoCount, "learn Spring Boot", false));
                todos.add(new Todo(++todoCount, "Grocery store", false));
                todos.add(new Todo(++todoCount, "learn AWS", false));
                todos.add(new Todo(++todoCount, "Swimming", false));
                todos.add(new Todo(++todoCount, "Yoga", false));
            }
            public List<Todo>findAll(){   // business logic
                return todos;
            }
            public Todo findById(int id){
                // java logic
                Predicate<? super Todo> predicate=todo -> todo.getId()==id;   // business logic
                Todo todo=todos.stream().filter(predicate).findFirst().get();
               return todo;

            }
            public void addTodo(Todo todo){
                todos.add(todo);
            }
            public void deleteTodo(int id){
                Predicate<? super Todo> predicate=todo -> todo.getId()==id;
                todos.removeIf(predicate);
                //todos.remove();
            }
            public void updateTodo(int id,Todo newTodo){
                // get todo
                // find todo to be updated
                Todo todo=findById(id);
                todo.setId(newTodo.getId());
                todo.setTitle(newTodo.getTitle());
                todo.setStatus(newTodo.getStatus());

            }

}
