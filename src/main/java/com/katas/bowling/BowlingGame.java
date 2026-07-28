package com.katas.bowling;

public class BowlingGame {

    public int[] rolls = new int[21];
    int current = 0;

    public void roll(int pins) {
        rolls[current++] = pins;
    }

    public int score() {
        int score = 0;
        int i = 0;
        for (int frame = 0; frame<10; frame++) {
            if (rolls[i] == 10) {       // strike
                score += 10 + rolls[i + 1] + rolls[i + 2];
                i += 1;
            } else if (rolls[i] + rolls[i+1] == 10) { //spare
                score += 10 + rolls[i + 2];
                i += 2;
            } else {
                score += rolls[i] + rolls[i + 1];
                i += 2;
            }
        }
        return score;
    }

}
