package com.example.demo.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/person")

public record PersonController(PersonService personService) {
    @Autowired
    public PersonController {
    }

    @GetMapping
    public List<Person> getPerson() {
        return personService.getListPerson();
    }

    @PostMapping
    public void NewPerson(@RequestBody Person person) {
        personService.addPerson(person);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long personId) {
        personService.deletePerson(personId);
    }

    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable("personId") Long personId,
            @RequestBody Person person){
        personService.updatePerson(personId, person);
    }

}
