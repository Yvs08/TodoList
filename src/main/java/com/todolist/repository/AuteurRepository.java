package com.todolist.repository;

import com.todolist.domain.Auteur;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AuteurRepository extends MongoRepository<Auteur, String> {

    public List<Auteur> findByName(String name);

    public Auteur findByFunction(String function);

    public Auteur deleteByName(String name);

}
