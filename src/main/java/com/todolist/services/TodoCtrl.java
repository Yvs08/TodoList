package com.todolist.services;

import com.todolist.domain.Todo;
import com.todolist.repository.TodoRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoCtrl {

    @Autowired
    private TodoRepository todoRepository;

    @RequestMapping(value = "/addtodo", method = RequestMethod.GET)
    public Todo todo(@RequestParam(value = "titre") String titre,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "numero") String numero) {
        Date dateDeCreation = new Date();
        Date dateEcheance = new Date();
        String etat = "todo";

        Todo tod = new Todo(numero, titre, description, dateDeCreation, dateEcheance, etat);

        todoRepository.save(tod);
        return tod;

    }
    
     @RequestMapping(value = "/addtodoa", method = RequestMethod.POST)
    public void todo(@RequestBody Todo t) {
        
         todoRepository.save(t);
        
    }
      @RequestMapping(value = "/deletevialeformu", method = RequestMethod.POST)
    public void todo(@RequestBody String a) {
        
         todoRepository.deleteByNumero(a);
        
    }


    @RequestMapping(value = "/validate/{numero}", method = RequestMethod.GET)
    public Todo validate(@PathVariable("numero") String numero) throws RuntimeException {

        Function<Todo, Todo> plop = t -> {
            String avant = t.getEtat();
            String etat = "done";
            String faire = "todo";
            if (faire.equals(avant)) {
                t.setEtat(etat);
                return todoRepository.save(t);
            }
            return t;
        };

        Supplier<String> foo = () -> "meh";
        final BiFunction<Integer, Integer, String> bazbar = (a, b) -> a.toString() + b.toString();
        System.out.println(bazbar.apply(123, 456));
        final BiFunction<String, Integer, Integer> remapper = (k, v) -> v == null ? 42 : v + 41;
        return Optional.ofNullable(todoRepository.findByNumero(numero))
                .map(plop).orElseThrow(() -> new RuntimeException("pas de todo avec ce numero"));

    }

    @RequestMapping(value = "/validateList/", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> validateList(@RequestParam List<String> todo) {

        return todo.stream().map(this::validate).collect(Collectors.toList());

    }

    @RequestMapping(value = "/voir", method = RequestMethod.GET)
    @ResponseBody
    public String voir() {

        String B = "Salut";
        return B;

    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> toda() {

        return todoRepository.findAll();

    }

    @RequestMapping(value = "/delete/{numero}", method = RequestMethod.GET)
    public List<Todo> getodo(@PathVariable("numero") String numero) {

        Todo get = todoRepository.findByNumero(numero);
        String avant = get.getEtat();
        if ("done".equals(avant)) {
            todoRepository.deleteByNumero(numero);
            return todoRepository.findAll();
        } else {
            return todoRepository.findAll();
        }

    }

    @RequestMapping(value = "/lister/{etat}", method = RequestMethod.GET)
    public List<Todo> todo(@PathVariable("etat") Optional<String> etat) {
        return etat
                .map(e -> {
                    return todoRepository
                            .findAll()
                            .stream()
                            .filter(d -> d.getEtat().equals(e))
                            .collect(Collectors.toList());
                })
                .orElseGet(() -> {
                    return todoRepository.findAll();

                });

    }

    @RequestMapping(value = "/filtrer/{dateDeCheance}", method = RequestMethod.GET)
    public List<Todo> gtodo(@PathVariable("dateDeCheance") @DateTimeFormat(pattern = "dd.MM.yyyy") Optional<Date> dateDeCheance) {

        return dateDeCheance
                .map(e -> {
                    return todoRepository
                            .findAll()
                            .stream()
                            .filter(d -> d.getDateDeCheance().compareTo(e) > 0)
                            .collect(Collectors.toList());
                })
                .orElseGet(() -> {
                    return todoRepository.findAll();

                });

    }

}
