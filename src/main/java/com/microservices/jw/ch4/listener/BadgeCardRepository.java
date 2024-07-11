package com.microservices.jw.ch4.listener;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * BadgeCard 데이터 작업 처리
 */
public interface BadgeCardRepository extends JpaRepository<BadgeCard, Long> {

    /**
     * 주어진 사용자의 배지 카드를 모두 조회
     */
    List<BadgeCard> findByUserIdOrderByBadgeTimestampDesc(final Long userId);
}
