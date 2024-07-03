package com.microservices.jw.ch1;


import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomNumGeneratorServiceImpl implements RandomNumGeneratorService{

    final static int MINIMUM_NUMBER = 11;
    final static int MAXIMUM_NUMBER = 99;
    @Override
    public int generateRandomNumber() {
        return new Random().nextInt((MAXIMUM_NUMBER - MINIMUM_NUMBER) + 1) + MINIMUM_NUMBER;
    }
}
