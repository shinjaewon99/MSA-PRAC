package com.microservices.jw.ch2;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class MultiplicationServiceImpl implements MultiplicationService {
    @Override
    public Multiplication createRandomMultiplication() {
        return null;
    }

    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {
        boolean correct = resultAttempt.resultAttempt() ==
                resultAttempt.multiplication().numberA() * resultAttempt.multiplication().numberB();
        // Spring Framework 에서 제공하는 Assert는 애플리케이션내에서 조건을 검증하고 예외를 던지는데 사용
        // Assert.isTrue(!resultAttempt.isCorrect(), "채점한 상태로 보낼 수 없습니다.");

        MultiplicationResultAttempt checkedAttempt =
                new MultiplicationResultAttempt(resultAttempt.user(), resultAttempt.multiplication(), resultAttempt.resultAttempt());


        return correct;
    }
}
