
package com.todolist.repository;

import com.todolist.domain.Todo;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {

    public List<Todo> findByTitre(String titre);
    
    public Todo findByNumero(String numero);
    
    public Todo deleteByNumero(String numero);

}
