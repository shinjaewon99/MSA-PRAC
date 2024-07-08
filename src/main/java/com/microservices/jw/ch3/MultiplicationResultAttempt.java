package com.microservices.jw.ch3;

import jakarta.persistence.*;
import lombok.*;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Entity
public final class MultiplicationResultAttempt {

    @Id
    @Generated
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "MULTIPLICATION_ID")
    private Multiplication multiplication;

    private int resultAttempt;

    private boolean correct;
}
