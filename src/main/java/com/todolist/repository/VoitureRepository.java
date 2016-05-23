/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.todolist.repository;

import com.todolist.domain.Voiture;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VoitureRepository extends MongoRepository<Voiture, String> {
    
    public List<Voiture> findByNumero(String numero);
    

}
