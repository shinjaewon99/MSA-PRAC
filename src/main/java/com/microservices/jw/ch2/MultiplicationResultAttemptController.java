package com.microservices.jw.ch2;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/results")
public final class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;

    // POST 구현체를 추가

    @RequiredArgsConstructor
    @NoArgsConstructor(force = true) // 타입의 기본값이 자동으로 설정되는 옵션, String -> null, Integer -> null, int -> 0
    @Getter
    static final class ResultResponse {
        private final boolean correct;
    }
}
