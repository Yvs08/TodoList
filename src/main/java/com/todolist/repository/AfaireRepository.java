package com.todolist.repository;

import com.todolist.domain.Afaire;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AfaireRepository extends MongoRepository<Afaire, String> {

    public Afaire findByNumber(String number);

    public List<Afaire> findByTitle(String title);

}
