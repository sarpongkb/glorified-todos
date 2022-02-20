package com.sarpongkb.sbtodo.todo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoListServiceImpl implements TodoListService {

  private TodoListRepository todoListRepository;

  public TodoListServiceImpl(TodoListRepository todoListRepository) {
    this.todoListRepository = todoListRepository;
  }

  @Override
  public TodoList create(String name) {
    var todoList = new TodoList();
    todoList.setName(name);
    return todoListRepository.save(todoList);
  }

  @Override
  public TodoList get(Long id) {
    return todoListRepository.findById(id).orElseThrow();
  }

  @Override
  public Boolean delete(Long id) {
    todoListRepository.deleteById(id);
    return true;
  }

  @Transactional
  @Override
  public void createTodoItem(Long id, TodoItem todoItem) {
    var todoList = todoListRepository.findById(id).orElseThrow();
    todoList.addTodoItem(todoItem);
    todoListRepository.save(todoList);
  }
 
}
