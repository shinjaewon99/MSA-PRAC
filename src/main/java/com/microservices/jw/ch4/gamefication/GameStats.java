package com.microservices.jw.ch4.gamefication;

import com.microservices.jw.ch4.listener.Badge;
import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public record GameStats(Long userId, int score, List<Badge> badges) {

    /**
     * 빈 인스턴스 (0점과 배지가 없는상태) 를 만들기 위한 팩토리 메소드
     *
     * @param userId 사용자 Id
     * @return 객체 (0젖ㅁ과 배지가 없는상태)
     */
    public static GameStats emptyStats(final Long userId) {
        return new GameStats(userId, 0, Collections.emptyList());
    }

    /**
     *
     * @return 수정 가능한 배지 카드 리스트 반환
     */
    public List<Badge> getBadges() {
        return Collections.unmodifiableList(badges);
    }


}
