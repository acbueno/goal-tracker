package br.com.acbueno.limeira.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.acbueno.limeira.model.Plan;

public interface PlanRepository extends MongoRepository<Plan, String> {

}
