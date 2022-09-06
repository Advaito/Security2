package com.example.util;


import com.example.models.User;
import com.example.service.PersonDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PersonValidator implements Validator {

    private final PersonDetailsService personDetailsService;

    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        try {
            personDetailsService.loadUserByUsername(user.getUsername());
        } catch (UsernameNotFoundException ignored) {
            return;
        }
        errors.rejectValue("username", "", "Takoy est uzhe");
    }
}
