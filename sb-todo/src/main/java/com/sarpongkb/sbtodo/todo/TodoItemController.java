package com.sarpongkb.sbtodo.todo;

import java.time.LocalDateTime;

import com.sarpongkb.sbtodo.util.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo-item")
public class TodoItemController {

  @PutMapping("/{id}")
  public ResponseEntity<Response> updateTodoItem(@RequestBody TodoItemDto todoItemDto) {
    return ResponseEntity.ok(
        Response.builder()
            .timeStamp(LocalDateTime.now())
            .status(HttpStatus.OK)
            .statusCode(HttpStatus.OK.value())
            // .data(Map.of("todoList", todoListService.create(todoItemDto)))
            .build());
  }
}
