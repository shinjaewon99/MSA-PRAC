package com.microservices.jw.ch4.listener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

/**
 * 배지와 사용자를 연결하는 클래스
 * 사용자가 배지를 획득한 순간의 타임스탬프를 포함
 */
@Getter
@Entity
@ToString
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class BadgeCard {

    @Id
    @GeneratedValue
    @Column(name = "BADGE_ID")
    private Long badgeId;

    private Long userId;
    private long badgeTimestamp;
    private Badge badge;


    public BadgeCard(final Long userId, final Badge badge) {
        this(null, userId, System.currentTimeMillis(), badge);
    }
}
