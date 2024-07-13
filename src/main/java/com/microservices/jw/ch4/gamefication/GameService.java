package com.microservices.jw.ch4.gamefication;

/**
 * 게임화 시스템의 주요 로직을 다루는 서비스
 */
public interface GameService {


    /**
     * 주어진 사용자가 제출한 답안을 처리
     * @param userId 사용자 Id
     * @param attemptId 필요한 경우 추가로 데이터를 조회하기 위한 답안 Id
     * @param correct 답안의 정답 여부
     * @return 새로운 점수와 배치 카드를 포함한 객체
     */
    GameStats newAttemptForUser(Long userId, Long attemptId, boolean correct);

    /**
     * 주어진 사용자의 게임 통계를 조회
     * @param userId 사용자 Id
     * @return 사용자의 통계 정보
     */
    GameStats retrieveStatsForUser(Long userId);
}
