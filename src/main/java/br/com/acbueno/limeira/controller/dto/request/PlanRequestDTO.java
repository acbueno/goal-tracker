package br.com.acbueno.limeira.controller.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class PlanRequestDTO {

  private String name;

  private String category;

  private LocalDateTime startDate;

  private LocalDateTime dueDate;

  private String priority;

  private int progress;

  private List<GoalRequestDTO> goals;

}
