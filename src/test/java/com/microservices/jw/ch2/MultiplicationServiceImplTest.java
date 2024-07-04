package com.microservices.jw.ch2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MultiplicationServiceImplTest {

    @Autowired
    private MultiplicationServiceImpl multiplicationServiceImpl;

    @Test
    void checkCorrectAttemptTest() {

        // given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("jw_do");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000);

        // when
        boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);


        assertThat(attemptResult).isTrue();
    }

    @Test
    void checkWrongAttemptTest() {

        // given
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("jw_do");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3100);

        // when
        boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);


        assertThat(attemptResult).isFalse();
    }
}
