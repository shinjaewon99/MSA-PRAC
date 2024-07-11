package com.microservices.jw.ch4.listener;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * ScoreCard CRUD 작업 처리
 */
public interface ScoreCardRepository extends JpaRepository<ScoreCard, Long> {
    /**
     * ScoreCard 점수를 합해서 사용자의 총 점수를 조회
     *
     * @param userId 총 점수를 조회하고자 하는 사용자의 ID
     * @return 사용자의 총 점수
     */
    @Query("SELECT SUM(s.score) " +
            "FROM ScoreCard s " +
            "WHERE s.userId = :userId " +
            "GROUP BY s.userId")
    int getTotalScoreForUser(@Param("userId") final Long userId);

    /**
     * 사용자와 사용자의 총 점수를 나타내는 리스트를 조회
     */
    @Query("SELECT NEW com.microservices.jw.ch4.listener.LeaderBoardRow (" +
            "s.userId, SUM(s.score))" +
            "FROM ScoreCard s " +
            "GROUP BY s.userId ORDER BY SUM(s.score) DESC ")
    List<LeaderBoardRow> findFirst10();

}
