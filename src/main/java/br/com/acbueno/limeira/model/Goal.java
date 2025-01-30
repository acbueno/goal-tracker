package br.com.acbueno.limeira.model;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class Goal {

  private String goalId;

  private String name;

  private String status;

  private int progress;

  private List<String> notes;

  public Goal() {
    this.goalId = UUID.randomUUID().toString();
  }

}
