package com.microservices.jw.ch4;

import com.microservices.jw.ch3.Multiplication;
import com.microservices.jw.ch3.User;
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

    public MultiplicationResultAttempt(final User user, final Multiplication multiplication,
                                       final int resultAttempt, final boolean isCorrect) {
        this.user = user;
        this.multiplication = multiplication;
        this.resultAttempt = resultAttempt;
        this.correct = isCorrect;
    }
}
