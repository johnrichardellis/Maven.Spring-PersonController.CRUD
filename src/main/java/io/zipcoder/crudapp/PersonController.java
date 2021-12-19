package io.zipcoder.crudapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonController {

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Person createPerson(Person p) {
        return service.create(p);
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public Person getPerson(int id) {
        return service.read(id);
    }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.PUT)
    public List<Person> getPersonList() {
        return service.read(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Person updatePerson(Person p) {
        return service.update(id, newData);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void DeletePerson(int id) {
        return service.delete(id);
    }


}
