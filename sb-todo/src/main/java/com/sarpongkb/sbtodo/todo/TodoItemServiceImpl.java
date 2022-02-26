package com.sarpongkb.sbtodo.todo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TodoItemServiceImpl implements TodoItemService {

  private TodoItemRepository todoItemRepository;
  private TodoListRepository todoListRepository;

  public TodoItemServiceImpl(TodoItemRepository todoItemRepository, TodoListRepository todoListRepository) {
    this.todoItemRepository = todoItemRepository;
    this.todoListRepository = todoListRepository;
  }

  @Override
  public TodoItem create(TodoItem todoItem) {
    var todoList = todoListRepository.findById(todoItem.getTodoList().getId()).orElseThrow();
    var createdTodoItem = todoItemRepository.save(todoItem);
    todoList.addTodoItem(createdTodoItem);
    return createdTodoItem;
  }

  @Override
  public TodoItem get(Long id) {
    return todoItemRepository.findById(id).orElseThrow();
  }

  @Override
  public List<TodoItem> getAll() {
    return todoItemRepository.findAll();
  }

  @Override
  public TodoItem update(TodoItem todoItem) {
    var retrievedTodoItem = todoItemRepository.getById(todoItem.getId());

    if (todoItem.getCompleted() != null) {
      retrievedTodoItem.setCompleted(todoItem.getCompleted());
    }

    if (todoItem.getDescription() != null) {
      retrievedTodoItem.setDescription(todoItem.getDescription());
    }

    return todoItemRepository.save(retrievedTodoItem);
  }

  @Override
  public Boolean delete(Long id) {
    todoItemRepository.deleteById(id);
    return true;
  }
}
