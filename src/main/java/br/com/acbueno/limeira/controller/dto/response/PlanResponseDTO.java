package br.com.acbueno.limeira.controller.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class PlanResponseDTO {

  private String planId;

  private String name;

  private String category;

  private LocalDateTime startDate;

  private LocalDateTime dueDate;

  private String priority;

  private Integer progress;

  private List<GoalResponseDTO> goals;

}
