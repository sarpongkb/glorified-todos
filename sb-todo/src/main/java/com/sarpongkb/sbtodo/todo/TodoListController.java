package com.sarpongkb.sbtodo.todo;

import java.time.LocalDateTime;
import java.util.Map;

import com.sarpongkb.sbtodo.util.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo-list")
public class TodoListController {
  private TodoListService todoListService;
  private TodoManager todoManager;

  public TodoListController(TodoListService todoListService, TodoManager todoManager) {
    this.todoListService = todoListService;
    this.todoManager = todoManager;
  }

  @PostMapping("")
  public ResponseEntity<Response> createTodoList(@RequestBody TodoListDto listDto) {
    var todoList = todoListService.create(todoManager.fromTodoListDto(listDto));

    return ResponseEntity.ok(
        Response.builder()
            .timeStamp(LocalDateTime.now())
            .status(HttpStatus.CREATED)
            .statusCode(HttpStatus.CREATED.value())
            .data(Map.of("todoList", todoManager.toTodoListDto(todoList)))
            .build());
  }

  @PostMapping("/{id}/todo-item")
  public ResponseEntity<Response> createTodoItem(@PathVariable Long id, @RequestBody TodoItemDto itemDto) {
    var todoItem = todoListService.createTodoItem(id, todoManager.fromTodoItemDto(itemDto));
  
    return ResponseEntity.ok(
        Response.builder()
            .timeStamp(LocalDateTime.now())
            .status(HttpStatus.CREATED)
            .statusCode(HttpStatus.CREATED.value())
            .data(Map.of("todoItem", todoManager.toTodoItemDto(todoItem)))
            .build());
  }
}
