package com.microservices.jw.ch1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultiCalCuServiceImpl implements MultiCalCuService {

    private RandomNumGeneratorService randomNumGeneratorService;

    @Autowired
    public MultiCalCuServiceImpl (final RandomNumGeneratorService randomNumGeneratorService) {
        this.randomNumGeneratorService = randomNumGeneratorService;
    }

    @Override
    public MultiCalCu createRandomMultiCalCu() {
        int number1 = randomNumGeneratorService.generateRandomNumber();
        int number2 = randomNumGeneratorService.generateRandomNumber();
        return new MultiCalCu(number1, number2);
    }
}
