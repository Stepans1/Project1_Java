package org.examples.config.util;


import org.examples.config.dao.PersonDAO;
import org.examples.config.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class PersonValidator implements Validator {

    private final PersonDAO personDAO;

    public PersonValidator(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person =(Person) target;

        if (personDAO.show(person.getSurname()).isPresent()){
            errors.rejectValue("name","","Name is already taken");
        }

    }
}
