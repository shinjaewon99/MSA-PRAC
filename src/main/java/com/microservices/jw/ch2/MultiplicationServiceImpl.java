package com.microservices.jw.ch2;

import com.microservices.jw.ch1.RandomNumGeneratorService;
import com.microservices.jw.ch3.MultiplicationResultAttemptRepository;
import com.microservices.jw.ch3.User;
import com.microservices.jw.ch3.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MultiplicationServiceImpl implements MultiplicationService {

    private final RandomNumGeneratorService randomNumGeneratorService;
    private final UserRepository userRepository;
    private final MultiplicationResultAttemptRepository multiplicationResultAttemptRepository;

    @Override
    public Multiplication createRandomMultiplication() {
        return null;
    }


    @Transactional
    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {

        // 해당 닉네임의 사용자가 존재하는지 확인
        Optional<User> user = userRepository.findByAlias(resultAttempt.user().alias());

        //조작된 답안을 방지
        // Assert.isTrue(!resultAttempt.isCorrect(), "채점한 채로 보낼 수 없습니다.");

        // 답안을 채점
        boolean isCorrect = resultAttempt.resultAttempt() ==
                resultAttempt.multiplication().numberA() * resultAttempt.multiplication().numberB();

        MultiplicationResultAttempt checkedAttempt =
                new MultiplicationResultAttempt(resultAttempt.user(), resultAttempt.multiplication(), resultAttempt.resultAttempt());
        // Spring Framework 에서 제공하는 Assert는 애플리케이션내에서 조건을 검증하고 예외를 던지는데 사용
        // Assert.isTrue(!resultAttempt.isCorrect(), "채점한 상태로 보낼 수 없습니다.");

        multiplicationResultAttemptRepository.save(checkedAttempt);


        return isCorrect;
    }
}
