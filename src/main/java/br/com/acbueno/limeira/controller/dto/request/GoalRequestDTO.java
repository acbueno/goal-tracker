package br.com.acbueno.limeira.controller.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class GoalRequestDTO {

  private String name;

  private String status;

  private int progress;

  private List<String> notes;

}
