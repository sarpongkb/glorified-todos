package com.sarpongkb.sbtodo.todo;

public interface TodoListService {
  TodoList create(TodoList todoList);

  TodoList get(Long id);

  Boolean delete(Long id);

  TodoItem createTodoItem(Long id, TodoItem todoItem);
}
