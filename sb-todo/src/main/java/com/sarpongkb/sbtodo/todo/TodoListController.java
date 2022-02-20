package com.sarpongkb.sbtodo.todo;

import java.time.LocalDateTime;
import java.util.Map;

import com.sarpongkb.sbtodo.util.Response;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo-list")
public class TodoListController {
  private TodoListService todoListService;

  public TodoListController(TodoListService todoListService) {
    this.todoListService = todoListService;
  }

  @PostMapping("")
  public ResponseEntity<Response> createTodoList(@RequestBody TodoList todoDto) {
    return ResponseEntity.ok(
        Response.builder()
            .timeStamp(LocalDateTime.now())
            .status(HttpStatus.CREATED)
            .statusCode(HttpStatus.CREATED.value())
            .data(Map.of("todoList", todoListService.create(todoDto.getName())))
            .build());
  }
}
