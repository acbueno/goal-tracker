package br.com.acbueno.limeira.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Document()
@Data
public class User {

  @Id
  private String id;

  private String name;

  private String email;

  private List<Plan> plans;

}
