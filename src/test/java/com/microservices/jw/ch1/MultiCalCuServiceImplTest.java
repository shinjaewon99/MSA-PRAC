package com.microservices.jw.ch1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class MultiCalCuServiceImplTest {

    private MultiCalCuServiceImpl multiCalCuServiceImpl;

    @Mock
    private RandomNumGeneratorService randomNumGeneratorService;

    @BeforeEach
    void setUp() {
        // 목 객체를 초기화
        MockitoAnnotations.initMocks(this);
        multiCalCuServiceImpl = new MultiCalCuServiceImpl(randomNumGeneratorService);
    }

    @Test
    void createRandomMultiCalCuTest() {
        given(randomNumGeneratorService.generateRandomNumber()).willReturn(50, 30);

        // when
        final MultiCalCu randomMultiCalCu = multiCalCuServiceImpl.createRandomMultiCalCu();

        // then
        assertThat(randomMultiCalCu.getNumber1()).isEqualTo(50);
        assertThat(randomMultiCalCu.getNumber2()).isEqualTo(30);
        assertThat(randomMultiCalCu.getResult()).isEqualTo(1500);
    }
}
