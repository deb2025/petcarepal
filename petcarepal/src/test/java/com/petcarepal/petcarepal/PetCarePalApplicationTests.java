package com.petcarepal.petcarepal;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.petcarepal.petcarepal.model.UserDtls;
import com.petcarepal.petcarepal.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class PetCarePalApplicationTests {
 
    @Autowired
    private TestEntityManager entityManager;
     
    @Autowired
    private UserRepository repo;
     
    @Test
    public void testCreateUser() {
    	UserDtls user = new UserDtls();
        user.setEmail("ravikumar@gmail.com");
        user.setPassword("ravi2020");
        user.setConfirm("ravi2020");
        user.setPhone("9564587454");
        user.setFullname("Ravi Kumar");
        user.setPetinfo("Kutti-Dog");
         
        UserDtls savedUser = repo.save(user);
         
        UserDtls existUser = entityManager.find(UserDtls.class, savedUser.getId());
         
        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
         
    }
}
