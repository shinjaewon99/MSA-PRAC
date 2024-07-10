package com.microservices.jw.ch4;

import com.microservices.jw.ch1.RandomNumGeneratorService;
import com.microservices.jw.ch3.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MultiplicationServiceImpl implements MultiplicationService {

    private RandomNumGeneratorService randomNumGeneratorService;
    private MultiplicationResultAttemptRepository multiplicationResultAttemptRepository;
    private UserRepository userRepository;
    private EventDispatcher eventDispatcher;


    @Override
    public Multiplication createRandomMultiplication() {
        int numberA = randomNumGeneratorService.generateRandomNumber();
        int numberB = randomNumGeneratorService.generateRandomNumber();

        return new Multiplication(numberA, numberB);
    }

    @Transactional
    @Override
    public boolean checkAttempt(final MultiplicationResultAttempt resultAttempt) {
        // 해당 닉네임의 사용자가 존재하는지 확인
        Optional<User> user = userRepository.findByAlias(resultAttempt.getUser().getAlias());

        boolean isCorrect
                = resultAttempt.getResultAttempt()
                == resultAttempt.getMultiplication().getNumberA() * resultAttempt.getMultiplication().getNumberB();

        // 복사본을 만들고 correct 필드를 상황에 맞춰 설정
        MultiplicationResultAttempt checkedAttempt =
                new MultiplicationResultAttempt(user.orElse(resultAttempt.getUser()),
                        resultAttempt.getMultiplication(), resultAttempt.getResultAttempt(), isCorrect);

        // 답안을 저장
        multiplicationResultAttemptRepository.save(checkedAttempt);

        // 이벤트로 결과를 전송
        eventDispatcher.send(new MultiplicationSolvedEvent(
                checkedAttempt.getId(),
                checkedAttempt.getUser().getId(),
                checkedAttempt.isCorrect()
        ));

        return isCorrect;
    }

    @Override
    public List<MultiplicationResultAttempt> getStatsForUser(String userAlias) {
        return multiplicationResultAttemptRepository.findTo5ByUserAliasOrderByIdDesc(userAlias);
    }
}
