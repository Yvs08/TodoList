package com.todolist.services;

import com.todolist.domain.Voiture;
import com.todolist.repository.VoitureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoitCtrl {

    @Autowired
    private VoitureRepository voitureRepository;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Voiture voiture(@RequestParam(value = "numero") String numero) {

        Voiture bmw = new Voiture(numero);

        Voiture x = voitureRepository.save(bmw);
        return bmw;

    }
}
