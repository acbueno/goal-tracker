package br.com.acbueno.limeira.controller.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class UserResponseDTO {

  private String id;

  private String name;

  private String email;

  private List<PlanResponseDTO> plans;

}
