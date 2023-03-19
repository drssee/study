package org.zerock.api01.repository;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.api01.domain.APIUser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class APIUserRepositoryTests {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private APIUserRepository apiUserRepository;

    @Test
    @Transactional
    public void testInserts() {
        List<APIUser> apiUsers = new ArrayList<>();
        IntStream.rangeClosed(1,100).forEach(i -> {
            APIUser apiUser = APIUser.builder()
                    .mid("apiuser"+i)
                    .mpw(passwordEncoder.encode("1111"))
                    .build();

            apiUsers.add(apiUser);
        });
        log.info(apiUsers);
        List<APIUser> apiUsers1 = apiUserRepository.saveAll(apiUsers);
        Assertions.assertEquals(apiUsers1.size(), 100);
    }
}
