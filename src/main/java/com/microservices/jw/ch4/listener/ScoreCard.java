package com.microservices.jw.ch4.listener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/**
 * 점수와 답안을 연결하는 클래스
 * 사용자와 점수가 등록된 시간의 타임스탬프를 포함
 */
@Getter
@Entity
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScoreCard {

    // 명시되지 않은 경우 이 카드에 할당되는 기본 점수
    public static final int DEFAULT_SCORE = 10;

    @Id
    @GeneratedValue
    @Column(name = "CARD_ID")
    private Long cardId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ATTEMPT_ID")
    private Long attemptId;

    @Column(name = "SCORE_TS")
    private long scoreTimestamp;

    @Column(name = "SCORE")
    private int score;

    public ScoreCard(final Long userId, final Long attemptId) {
        this(null, userId, attemptId, System.currentTimeMillis(), DEFAULT_SCORE);
    }
}
