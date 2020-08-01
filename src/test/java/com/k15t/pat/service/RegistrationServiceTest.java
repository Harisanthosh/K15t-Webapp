package com.k15t.pat.service;

import com.k15t.pat.exception.RegistrationException;
import com.k15t.pat.model.User;
import com.k15t.pat.repository.RegistrationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationServiceTest
{

    @Autowired
    private RegistrationRepository registrationRepository;

    @Autowired
    private RegistrationService registrationService;

    @Test
    public void newUserRegistration_thenUserCreated() throws RegistrationException
    {
        User user = new User();
        user.setName("Camrade");
        user.setEmail("harisanthosh@gmail.com");
        user.setAddress("12,naran");
        user.setCity("stuttgart");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setCountry("DE");
        registrationService.saveUser(user);
        assertNotNull(registrationRepository.getOne(1L));
    }

    @Test
    public void saveUserRegistration() throws RegistrationException
    {
        User user = new User();
        user.setName("Camrade");
        user.setEmail("harisanthosh1@gmail.com");
        user.setAddress("12,naran");
        user.setCity("stuttgart");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setCountry("DE");
        User registeredUser = registrationService.saveUser(user);
        assertNotNull(registeredUser.getId());
    }

    @Test(expected = RegistrationException.class)
    public void whenNameAlreadyExists_thenUserIsNotCreated() throws RegistrationException
    {
        User user = new User();
        user.setName("Camrade");
        user.setEmail("harisanthosh12@gmail.com");
        user.setAddress("12,naran");
        user.setCity("stuttgart");
        user.setPassword("12345678");
        user.setPhone("0123456789");
        user.setCountry("DE");
        registrationService.saveUser(user);
        registrationService.saveUser(user);
    }

}
