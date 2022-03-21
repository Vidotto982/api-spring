package com.example.demo.person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PersonService {
    @Autowired
    private final PersonRepository personRepository;
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getListPerson() {
        return personRepository.findAll();
    }

    public void addNewPerson(Person person){
        Optional<Person> personOptional = personRepository
                .findPersonByName(person.getName());
        if (personOptional.isPresent()) {
            throw new IllegalStateException("Name Taken");
        }
        personRepository.save(person);
    }
    public void deletePerson(Long personId){
        boolean exists = personRepository.existsById(personId);
        if (!exists){
            throw new IllegalStateException("Person Not Exist");
        }
        personRepository.deleteById(personId);
    }
    @Transactional
    public void updatePerson(Long personId, Person person) {
        Person foundPerson= personRepository.findById(personId)
                .orElseThrow(() -> new IllegalStateException(
                        "person not exist"
                ));
        if (person.getName() != null && person.getName().length()>0 && !Objects.equals(foundPerson.getName(), person.getName())) {
            foundPerson.setName(person.getName());
        }
        if (person.getCountry() != null && person.getCountry().length()>0 && !Objects.equals(foundPerson.getCountry(), person.getCountry())) {
            Optional<Person> personOptional = personRepository.findPersonByCountry(person.getCountry());
            if (personOptional.isPresent()){
                throw new IllegalStateException("taken");
            }
        }
        foundPerson.setName(person.getCountry());
    }
}
