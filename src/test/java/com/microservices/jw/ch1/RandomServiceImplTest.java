package com.microservices.jw.ch1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomServiceImplTest {

    private RandomNumGeneratorServiceImpl randomNumGeneratorService;

    @BeforeEach
    void setUp() {
        randomNumGeneratorService = new RandomNumGeneratorServiceImpl();
    }

    @Test
    void createRandomNumberIsBetweenLimitsTest() {
        List<Integer> randomNumbers = IntStream.range(0, 1000)
                .map(i -> randomNumGeneratorService.generateRandomNumber())
                .boxed()
                .collect(Collectors.toList());

        // 생성한 인수가 11 ~ 99 범위에 있는지 확인
        Assertions.assertThat(randomNumbers)
                .containsOnlyElementsOf(IntStream.range(11, 100).boxed().collect(Collectors.toList()));
    }
}
