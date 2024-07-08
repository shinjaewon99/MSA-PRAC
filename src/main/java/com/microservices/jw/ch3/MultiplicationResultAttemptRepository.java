package com.microservices.jw.ch3;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 답안을 저장하고 조회하기 위한 인터페이스
 */
public interface MultiplicationResultAttemptRepository extends JpaRepository<MultiplicationResultAttempt, Long> {

    /**
     * @return 닉네임에 해당하는 사용자의 최근 답안 5개
     */

    List<MultiplicationResultAttempt> findTo5ByUserAliasOrderByIdDesc(String userAlias);
}
