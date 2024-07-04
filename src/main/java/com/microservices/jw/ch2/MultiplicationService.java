package com.microservices.jw.ch2;

public interface MultiplicationService {

    /**
     * 두 개의 무작위 인수 (11~99)를 담은 Multiplication 객체를 생성
     *
     */
    Multiplication createRandomMultiplication();

    /**
     * 곱센 계산 결과가 맞으면 true, 아니면 false
     */
    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
