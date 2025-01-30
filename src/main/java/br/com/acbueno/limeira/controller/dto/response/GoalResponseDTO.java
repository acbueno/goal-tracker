package br.com.acbueno.limeira.controller.dto.response;

import lombok.Data;

@Data
public class GoalResponseDTO {

  private String goalId;

  private String name;

  private String status;

  private Integer progress;

  private String notes;

}
