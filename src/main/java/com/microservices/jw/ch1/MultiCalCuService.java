package com.microservices.jw.ch1;

public interface MultiCalCuService {

    /**
     * 두개의 무작위 인수를 담은 객체를 생성
     * 무작위의 숫자 범위는 11~99
     *
     * @return 무작위 인수를 담은 객체
     */
    MultiCalCu createRandomMultiCalCu();
}
