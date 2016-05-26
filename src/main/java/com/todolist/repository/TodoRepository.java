
package com.todolist.repository;

import com.todolist.domain.Todo;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {

    public List<Todo> findByTitle(String title);
    
    public Todo findByNumber(String number);
    public Todo findByState(String state);
    
    public Todo deleteByNumber(String number);

}
