package com.sarpongkb.sbtodo.todo;

import java.util.List;

public interface TodoItemService {
  TodoItem create(TodoItem todoItem);

  TodoItem get(Long id);

  List<TodoItem> getAll();

  TodoItem update(TodoItem todoItem);

  Boolean delete(Long id);
}
