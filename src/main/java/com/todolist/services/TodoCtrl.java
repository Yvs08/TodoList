package com.todolist.services;

import com.todolist.domain.Todo;
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
    public void addTodoByForms(@RequestBody Todo t) {

        todoRepository.save(t);

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

        return Optional.ofNullable(todoRepository.findByState(state))
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
