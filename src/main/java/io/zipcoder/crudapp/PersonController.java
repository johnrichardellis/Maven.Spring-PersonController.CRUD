package io.zipcoder.crudapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(Person p) {
        return service.createPerson(p);
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(int id) {
        return service.getPerson(id);
    }

//    @RequestMapping(value = "/read/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<List<Person>> getPersonList() {
//        return service.read(id);
//    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(Person p) {
        return service.updatePerson(id, newData);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Person> DeletePerson(int id) {
        return service.deletePerson(id);
    }


}
