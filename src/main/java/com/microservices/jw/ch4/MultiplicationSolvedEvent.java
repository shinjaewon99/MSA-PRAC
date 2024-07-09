package com.microservices.jw.ch4;

import java.io.Serializable;

/**
 * 시스템에서 문제가 해결됐다는 사실을 모델링한 이벤트
 * 곱셈에 대한 컨텍스트 정보를 제공
 */
public record MultiplicationSolvedEvent(Long multiplicationResultAttemptId, Long userId,
                                        boolean correct) implements Serializable {

}
