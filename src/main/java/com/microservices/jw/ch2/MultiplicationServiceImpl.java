package com.microservices.jw.ch2;

import org.springframework.stereotype.Service;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
    @Override
    public Multiplication createRandomMultiplication() {
        return null;
    }

    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {
        int numberA = resultAttempt.multiplication().numberA();
        int numberB = resultAttempt.multiplication().numberB();
        int expectedAnswer = numberA * numberB;
        int actualAttempt = resultAttempt.resultAttempt();

        return actualAttempt == expectedAnswer;
    }
}
