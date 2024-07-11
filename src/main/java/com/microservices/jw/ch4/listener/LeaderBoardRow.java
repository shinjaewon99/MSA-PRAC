package com.microservices.jw.ch4.listener;

import lombok.*;

/**
 * 리더보드 내 위치를 나타내는 객체
 * 사용자와 전체 점수를 연결
 */
@Getter
@EqualsAndHashCode
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class LeaderBoardRow {

    private Long userId;
    private Long totalScore;

}
