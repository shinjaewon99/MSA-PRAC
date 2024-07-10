package com.microservices.jw.ch4;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/**
 * 애플리케이션에서 곱셉을 나타내는 클래스 (a * b)
 */
@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public final class Multiplication {

    @Id
    @GeneratedValue
    @Column(name = "MULTIPLICATION_ID")
    private Long id;

    // 두 인수
    private int numberA;
    private int numberB;

    public Multiplication(final int numberA, final int numberB) {
        this.numberA = numberA;
        this.numberB = numberB;
    }
}
