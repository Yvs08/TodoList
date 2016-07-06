package com.todolist.services;

import com.todolist.domain.Afaire;
import com.todolist.domain.Auteur;
import com.todolist.domain.Project;
import com.todolist.domain.Todo;
import com.todolist.repository.AfaireRepository;
import com.todolist.repository.AuteurRepository;
import com.todolist.repository.TodoRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
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
    @Autowired
    private AuteurRepository auteurRepository;

    @Autowired
    private AfaireRepository afaireRepository;

    @RequestMapping(value = "/addtodo", method = RequestMethod.GET)
    public Todo addTodoByUrl(@RequestParam(value = "title") String title,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "number") String number) {
        String startDate = "13-08-2016";
        String dateDeadline = "13-08-2016";
        String state = "todo";

        Todo tod = new Todo(number, title, description, startDate, dateDeadline, state);

        todoRepository.save(tod);
        return tod;

    }

    @RequestMapping(value = "/addtodobyforms", method = RequestMethod.POST)
    public Todo addTodoByForms(@RequestBody Todo t) {

        todoRepository.save(t);

        return t;

    }

    @RequestMapping(value = "/addauteurbyforms", method = RequestMethod.POST)
    public Auteur addAuteurByForms(@RequestBody Auteur t) {

        auteurRepository.save(t);

        return t;

    }

    @RequestMapping(value = "/addauteurbyurl", method = RequestMethod.GET)
    @ResponseBody
    public List<Auteur> addAuteurByUrl() {

        return auteurRepository.findAll();

    }

    @RequestMapping(value = "/addafairebyurl", method = RequestMethod.GET)
    @ResponseBody
    public List<Afaire> addAfaireByUrl() {

        return afaireRepository.findAll();

    }

    @RequestMapping(value = "/addaffaire", method = RequestMethod.GET)
    public Afaire addAffaireByUrl(@RequestParam(value = "title") String title,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "number") String number, @RequestParam String function, @RequestParam String name, @RequestParam String society, @RequestParam String departement) {
        String startDate = "13-08-2016";
        String dateDeadline = "13-08-2016";
        String state = "todo";

        Auteur auteur = new Auteur(function, name, society, departement);

        auteurRepository.save(auteur);

        Afaire tod = new Afaire(number, title, description, startDate, dateDeadline, state, auteur);

        afaireRepository.save(tod);
        return tod;

    }
    @RequestMapping(value = "/addafairebyforms", method = RequestMethod.POST)
    public String addAfaireByForms(@RequestBody Project t) {
        String state = "todo";
        String function = t.getFunction();
        String name = t.getName();
        String society = t.getSociety();
        String departement = t.getDepartment();

        Auteur auteur = new Auteur(function, name, society, departement);
        auteurRepository.save(auteur);

        String number = t.getNumber();
        String title = t.getTitle();
        String description = t.getDescription();
        String startDate = t.getStartDate();
        String dateDeadline = t.getDateDeadline();
        Afaire tod = new Afaire(number, title, description, startDate, dateDeadline, state, auteur);
        afaireRepository.save(tod);
        return name;

    }

    @RequestMapping(value = "/deletetodobyforms", method = RequestMethod.POST)
    public void deleteTodoByForms(@RequestBody Todo todo) {

        String number = todo.getNumber();

        todoRepository.deleteByNumber(number);

    }

    @RequestMapping(value = "/validatetodobyforms", method = RequestMethod.POST)
    public Todo validateTodoByForms(@RequestBody Todo todo) {

        String number = todo.getNumber();

        Function<Todo, Todo> plop = t -> {
            String a = t.getState();
            String state = "done";
            String d = "todo";
            if (d.equals(a)) {
                t.setState(state);
                return todoRepository.save(t);
            }
            return t;
        };
        return Optional.ofNullable(todoRepository.findByNumber(number))
                .map(plop)
                .orElseThrow(() -> new RuntimeException("pas de todo avec ce numero"));

    }

    @RequestMapping(value = "/searchtodobyforms", method = RequestMethod.POST)
    public Todo searchTodoByForms(@RequestBody Todo todo) {

        String number = todo.getNumber();

        return todoRepository.findByNumber(number);

    }

    @RequestMapping(value = "/sorttodobyforms", method = RequestMethod.POST)
    public List<Todo> sortTodoByForms(@RequestBody Todo todo) {

        String state = todo.getState();

        return Optional.ofNullable(state)
                .map(e -> {
                    return todoRepository
                    .findAll()
                    .stream()
                    .filter(d -> d.getState().equals(e))
                    .collect(Collectors.toList());
                })
                .orElseGet(() -> {
                    return todoRepository.findAll();

                });

    }

    @RequestMapping(value = "/validate/{number}", method = RequestMethod.GET)
    public Todo validateTodoByUrl(@PathVariable("number") String number) throws RuntimeException {

        Function<Todo, Todo> plop = t -> {
            String a = t.getState();
            String state = "done";
            String d = "todo";
            if (d.equals(a)) {
                t.setState(state);
                return todoRepository.save(t);
            }
            return t;
        };

        final BiFunction<Integer, Integer, String> bazbar = (a, b) -> a.toString() + b.toString();
        System.out.println(bazbar.apply(123, 456));
        final BiFunction<String, Integer, Integer> remapper = (k, v) -> v == null ? 42 : v + 41;
        return Optional.ofNullable(todoRepository.findByNumber(number))
                .map(plop)
                .orElseThrow(() -> new RuntimeException("pas de todo avec ce numero"));

    }

    @RequestMapping(value = "/validateList/", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> validateListByUrl(@RequestParam List<String> todo) {

        return todo.stream().map(this::validateTodoByUrl).collect(Collectors.toList());

    }

    @RequestMapping(value = "/see", method = RequestMethod.GET)
    @ResponseBody
    public String see() {

        String B = "Hello";
        return B;

    }

    @RequestMapping(value = "/todo", method = RequestMethod.GET)
    @ResponseBody
    public List<Todo> listAllTodo() {

        return todoRepository.findAll();

    }

    @RequestMapping(value = "/delete/{number}", method = RequestMethod.GET)
    public List<Todo> deleteTodoByUrl(@PathVariable("number") String number) {

        Todo get = todoRepository.findByNumber(number);
        String avant = get.getState();
        if ("done".equals(avant)) {
            todoRepository.deleteByNumber(number);
            return todoRepository.findAll();
        } else {
            return todoRepository.findAll();
        }

    }

    @RequestMapping(value = "/lister/{state}", method = RequestMethod.GET)
    public List<Todo> todoListsByState(@PathVariable("state") Optional<String> state) {
        return state
                .map(e -> {
                    return todoRepository
                    .findAll()
                    .stream()
                    .filter(d -> d.getState().equals(e))
                    .collect(Collectors.toList());
                })
                .orElseGet(() -> {
                    return todoRepository.findAll();

                });

    }

    @RequestMapping(value = "/filtrer/{dateDeadline}", method = RequestMethod.GET)
    public List<Todo> todoListsByDateDeadline(@PathVariable("dateDeadline") @DateTimeFormat(pattern = "dd.MM.yyyy") Optional<String> dateDeadline) {

        return dateDeadline
                .map(e -> {
                    return todoRepository
                    .findAll()
                    .stream()
                    .filter(d -> d.getDateDeadline().compareTo(e) > 0)
                    .collect(Collectors.toList());
                })
                .orElseGet(() -> {
                    return todoRepository.findAll();

                });

    }

}
