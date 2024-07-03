package com.microservices.jw.ch1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@SpringBootTest
class MultiCalCuServiceTest {

    @MockBean
    private RandomNumGeneratorService randomNumGeneratorService;

    @Autowired
    private MultiCalCuService multiCalCuService;

    @Test
    void createRandomMultiCalCuTest() {
        // given 처음인수는 50, 두번째 인수는 30을 반환하도록 설정
        given(randomNumGeneratorService.generateRandomNumber()).willReturn(50, 30);

        // when
        final MultiCalCu randomMultiCalCu = multiCalCuService.createRandomMultiCalCu();

        // then
        assertThat(randomMultiCalCu.getNumber1()).isEqualTo(50);
        assertThat(randomMultiCalCu.getNumber2()).isEqualTo(30);
        assertThat(randomMultiCalCu.getResult()).isEqualTo(1500);
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