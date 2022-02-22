package com.sarpongkb.sbtodo.todo;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoListServiceImpl implements TodoListService {

  private TodoListRepository todoListRepository;
  private TodoItemRepository todoItemRepository;

  public TodoListServiceImpl(TodoListRepository todoListRepository, TodoItemRepository todoItemRepository) {
    this.todoListRepository = todoListRepository;
    this.todoItemRepository = todoItemRepository;
  }

  @Override
  public TodoList create(TodoList todoList) {
    // validation
    return todoListRepository.save(todoList);
  }

  @Override
  public TodoList get(Long id) {
    return todoListRepository.findById(id).orElseThrow();
  }

  @Override
  public List<TodoList> getAll() {
    return todoListRepository.findAll();
  }


  @Override
  public Boolean delete(Long id) {
    todoListRepository.deleteById(id);
    return true;
  }

  @Transactional
  @Override
  public TodoItem createTodoItem(Long id, TodoItem todoItem) {
    var todoList = todoListRepository.findById(id).orElseThrow();
    todoList.addTodoItem(todoItem);
    return todoItemRepository.save(todoItem);
  }
 
}
