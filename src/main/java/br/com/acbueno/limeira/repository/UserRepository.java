package br.com.acbueno.limeira.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.com.acbueno.limeira.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
