package com.sarpongkb.sbtodo.todo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoItem {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long listId;

  private String description;

  private Boolean completed;
}