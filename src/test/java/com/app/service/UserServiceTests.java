package com.app.service;

import com.app.repository.CompanyRepository;
import com.app.repository.UserRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class UserServiceTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @TestConfiguration
    public static class AppTestConfiguration {

        @MockBean
        private CompanyRepository companyRepository;

        @MockBean
        private UserRepository userRepository;

       /* @Bean
        public UserService userService() {
            return new UserService(companyRepository, userRepository);*/ // TODO: 2019-09-18
    }
}