package com.microservices.jw.ch4;

import com.microservices.jw.ch4.Multiplication;
import com.microservices.jw.ch4.MultiplicationResultAttempt;

import java.util.List;

public interface MultiplicationService {

    Multiplication createRandomMultiplication();

    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);

    List<MultiplicationResultAttempt> getStatsForUser(String userAlias);
}