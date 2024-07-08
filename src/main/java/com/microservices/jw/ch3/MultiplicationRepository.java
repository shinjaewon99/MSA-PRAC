package com.microservices.jw.ch3;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Multiplication을 저장하고 조회하기 위한 인터페이스
 */
public interface MultiplicationRepository extends JpaRepository<Multiplication, Long> {
    
}
