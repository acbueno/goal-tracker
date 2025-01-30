package br.com.acbueno.limeira.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Plan {

  private String planId;

  private String name;

  private String category;

  private LocalDateTime startDate;

  private LocalDateTime dueDate;

  private String priority;

  private int progress;

  private List<Goal> goals;

  public Plan() {
    this.planId = UUID.randomUUID().toString();
  }



}
