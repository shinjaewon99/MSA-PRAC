package com.microservices.jw.ch2;

/**
 * 애플리케이션에서 곱셈을 나타내는 클래스 (a * b)
 */

// 자바 14에서 도입된 record 사용 -> equals(), hashCode(), toString(), 필드 접근을 위한 get 메소드을 자동생성
// 자동으로 모든 필드를 final로 처리하여 불변성 보장
// @RequiredArgsConstructor 어노테이션도 사용 X, record는 모든 필드에대한 생성자를 제공
public record Multiplication(int numberA, int numberB) {


}

