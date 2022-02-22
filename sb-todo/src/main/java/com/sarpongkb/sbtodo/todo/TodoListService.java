package com.sarpongkb.sbtodo.todo;

import java.util.List;

public interface TodoListService {
  TodoList create(TodoList todoList);

  TodoList get(Long id);

  List<TodoList> getAll();

  Boolean delete(Long id);

  TodoItem createTodoItem(Long id, TodoItem todoItem);
}
