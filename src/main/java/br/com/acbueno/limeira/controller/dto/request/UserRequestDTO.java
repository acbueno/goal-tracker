package br.com.acbueno.limeira.controller.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class UserRequestDTO {

  private String name;

  private String email;

  private List<PlanRequestDTO> plans;

}
