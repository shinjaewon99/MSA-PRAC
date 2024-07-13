package com.microservices.jw.ch4.gamefication;

import com.microservices.jw.ch4.listener.LeaderBoardRow;

import java.util.List;

/**
 * LeaderBoard 에 접근하는 메서드를 제공
 */
public interface LeaderBoardService {

    /**
     * 최고 점수 사용자와 함께 현재 리더 보드를 검색
     * @return 최고 점수와 사용자
     */

    List<LeaderBoardRow> getCurrentLeaderBoard();
}
