package com.sarpongkb.sbtodo.todo;

import java.time.LocalDateTime;
import java.util.Map;

import com.sarpongkb.sbtodo.util.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo-item")
public class TodoItemController {

  private TodoManager todoManager;
  private TodoItemService todoItemService;

  public TodoItemController(TodoItemService todoItemService, TodoManager todoManager) {
    this.todoItemService = todoItemService;
    this.todoManager = todoManager;
  }

  @PostMapping("")
  public ResponseEntity<Response> createTodoItem(@RequestBody TodoItemDto todoItemDto) {
    var todoItem = todoItemService.create(todoManager.fromTodoItemDto(todoItemDto));

    return ResponseEntity.ok(
      Response.builder()
          .timeStamp(LocalDateTime.now())
          .status(HttpStatus.CREATED)
          .statusCode(HttpStatus.CREATED.value())
          .data(Map.of("todoItem", todoManager.toTodoItemDto(todoItem)))
          .build());
  }

  @GetMapping("")
  public ResponseEntity<Response> getAllTodoItems() {
    var todoItems = todoItemService.getAll();

    return ResponseEntity.ok(
      Response.builder()
          .timeStamp(LocalDateTime.now())
          .status(HttpStatus.OK)
          .statusCode(HttpStatus.OK.value())
          .data(Map.of("todoItems", todoManager.toTodoItemsDto(todoItems)))
          .build());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Response> getTodoItem(@PathVariable Long id) {
    var todoItem = todoItemService.get(id);

    return ResponseEntity.ok(
      Response.builder()
          .timeStamp(LocalDateTime.now())
          .status(HttpStatus.OK)
          .statusCode(HttpStatus.OK.value())
          .data(Map.of("todoItem", todoManager.toTodoItemDto(todoItem)))
          .build());
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Response> updateTodoItem(@PathVariable Long id, @RequestBody TodoItemDto todoItemDto) {
    var convertedItem = todoManager.fromTodoItemDto(todoItemDto);
    convertedItem.setId(id);
    var todoItem = todoItemService.update(convertedItem);

    return ResponseEntity.ok(
        Response.builder()
            .timeStamp(LocalDateTime.now())
            .status(HttpStatus.OK)
            .statusCode(HttpStatus.OK.value())
            .data(Map.of("todoItem", todoManager.toTodoItemDto(todoItem)))
            .build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Response> deleteTodoItem(@PathVariable Long id) {
    var itemDeleted = todoItemService.delete(id);

    return ResponseEntity.ok(
      Response.builder()
          .timeStamp(LocalDateTime.now())
          .status(HttpStatus.OK)
          .statusCode(HttpStatus.OK.value())
          .data(Map.of("itemDeleted", itemDeleted))
          .build());
  }
}
