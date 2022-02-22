package com.sarpongkb.sbtodo.todo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
class TodoManager {

  TodoList fromTodoListDto(TodoListDto dto) {
    var todoList = new TodoList();
    todoList.setId(dto.getId());
    todoList.setName(dto.getName());    
    return todoList;
  }

  TodoListDto toTodoListDto(TodoList todoList) {
    var dto = new TodoListDto();
    dto.setId(todoList.getId());
    dto.setName(todoList.getName());
    // dto.setTodoItems(toTodoItemsDto(todoList.getTodoItems())); // only if expand todoItems
    return dto;
  }

  List<TodoListDto> toTodoListsDto(List<TodoList> todoLists) {
    return todoLists.stream()
      .map(this::toTodoListDto)
      .toList();
  }

  TodoItem fromTodoItemDto(TodoItemDto dto) {
    var todoItem = new TodoItem();
    todoItem.setId(dto.getId());
    todoItem.setCompleted(dto.getCompleted());
    todoItem.setDescription(dto.getDescription());
    return todoItem;
  }

  TodoItemDto toTodoItemDto(TodoItem todoItem) {
    var dto = new TodoItemDto();
    dto.setId(todoItem.getId());
    dto.setCompleted(todoItem.getCompleted());
    dto.setDescription(todoItem.getDescription());
    dto.setListId(todoItem.getTodoList().getId());
    return dto;
  }

  List<TodoItemDto> toTodoItemsDto(List<TodoItem> todoItems) {
    return todoItems.stream()
      .map(this::toTodoItemDto)
      .toList();
  }

}
