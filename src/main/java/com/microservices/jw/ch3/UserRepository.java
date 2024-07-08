package com.microservices.jw.ch3;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * USER를 저장하고 조회하기 위한 인터페이스
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByAlias(final String alias);
}
