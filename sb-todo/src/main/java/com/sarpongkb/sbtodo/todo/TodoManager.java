package com.sarpongkb.sbtodo.todo;

public class TodoManager {

  public static TodoItem fromTodoItemDto(TodoItemDto dto) {
    var todoItem = new TodoItem();
    todoItem.setId(dto.getId());
    todoItem.setCompleted(dto.getCompleted());
    todoItem.setDescription(dto.getDescription());
    return todoItem;
  }

  public static TodoItemDto toTodoItemDto(TodoItem item) {
    var dto = new TodoItemDto();
    dto.setCompleted(item.getCompleted());
    dto.setDescription(item.getDescription());
    dto.setId(item.getId());
    //dto.setListId(item.getTodoList().getId());
    return dto;
  }

}
