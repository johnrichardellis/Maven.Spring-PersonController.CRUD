package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public PersonService() {
    }

    public Iterable<Person> index() {
        return repository.findAll();
    }

    public ResponseEntity<Person> createPerson(Person personRequestedToPersist) {
        Person personInDatabase = repository.save(personRequestedToPersist);
        ResponseEntity<Person> responseEntity = new ResponseEntity<>(personInDatabase, HttpStatus.CREATED);
        return responseEntity;
    }


    public ResponseEntity<Person> getPerson(Long id) {
        Person personInDatabase = repository.findById(id).get();
        return new ResponseEntity<>(personInDatabase, HttpStatus.OK);
    }


    public ResponseEntity<Person> updatePerson(Long id, Person newData) {
        Person personInDatabase = repository.findById(id).get();
        String newFirstName = newData.getFirstName();
        String newLastName = newData.getLastName();
        personInDatabase.setFirstName(newFirstName);
        personInDatabase.setLastName(newLastName);
        personInDatabase = repository.save(personInDatabase);
        return new ResponseEntity<>(personInDatabase, HttpStatus.OK);
    }


    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        Person personToBeDeleted = repository.findById(id).get();
        repository.deleteById(id);
        return new ResponseEntity<>(personToBeDeleted, HttpStatus.OK);

    }

}
