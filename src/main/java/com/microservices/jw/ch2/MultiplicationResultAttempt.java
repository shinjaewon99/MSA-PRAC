package com.microservices.jw.ch2;

public record MultiplicationResultAttempt(User user, Multiplication multiplication, int resultAttempt) {

    /* record에서는 빈생성자를 추가할 필요 없음, record는 모든 필드에 대한 생성자를 제공
    MultiplicationResultAttempt() {
        user = null;
        multiplication = null;
        resultAttempt = -1;
    }*/

}
