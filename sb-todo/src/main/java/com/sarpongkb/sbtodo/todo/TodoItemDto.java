package com.sarpongkb.sbtodo.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoItemDto {
  private Long id;
  private Long listId;
  private String description;
  private Boolean completed;
}
