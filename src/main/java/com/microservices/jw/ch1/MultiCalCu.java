package com.microservices.jw.ch1;

/**
 * 곱셉을 나타내는 클래스
 */
public class MultiCalCu {

    private int number1;
    private int number2;

    // number1 * number2의 결과
    private int result;

    public MultiCalCu(final int number1, final int number2) {
        this.number1 = number1;
        this.number2 = number2;
        this.result = number1 * number2;
    }

    public int getNumber1() {
        return number1;
    }

    public int getNumber2() {
        return number2;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "MultiCalCu{" +
                "number1=" + number1 +
                ", number2=" + number2 +
                ", result=" + result +
                '}';
    }
}
