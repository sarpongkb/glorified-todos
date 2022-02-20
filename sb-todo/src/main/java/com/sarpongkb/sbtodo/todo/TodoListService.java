package com.sarpongkb.sbtodo.todo;

public interface TodoListService {
  TodoList create(String name);

  TodoList get(Long id);

  Boolean delete(Long id);

  void createTodoItem(Long id, TodoItem todoItem);
}
