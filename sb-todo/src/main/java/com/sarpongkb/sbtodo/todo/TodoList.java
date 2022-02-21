package com.sarpongkb.sbtodo.todo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoList {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  @OneToMany(mappedBy = "todoList", orphanRemoval = true, cascade = CascadeType.ALL)
  private List<TodoItem> todoItems = new ArrayList<>();

  public void addTodoItem(TodoItem todoItem) {
    this.todoItems.add(todoItem);
    todoItem.setTodoList(this);
  }

  TodoItem getTodoItem(Long itemId) {
    return todoItems.stream().filter(item -> item.getId().equals(itemId)).findAny().get();
  }
}
