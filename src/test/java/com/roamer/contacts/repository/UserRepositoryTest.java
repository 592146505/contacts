package com.roamer.contacts.repository;

import com.roamer.contacts.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest()
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void findByUsername() {
        assertNotNull(userRepository);
        User user = userRepository.findByUsername("jbauer");
        assertNotNull(user);
        assertEquals(1, user.getId());
    }

    @Test
    public void save() {
        assertEquals(5, userRepository.count());
        User user = new User();
        user.setUsername("jbauer");
        user.setPassword("24hours");
        user = userRepository.save(user);
        assertEquals(6, user.getId());
        long count = userRepository.count();
        assertEquals(6, count);
    }
}