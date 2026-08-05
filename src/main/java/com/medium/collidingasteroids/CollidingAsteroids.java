package com.medium.collidingasteroids;

import java.util.ArrayDeque;
import java.util.Deque;

public class CollidingAsteroids {

    public int[] collidingAsteroids(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
                continue;
            }
            while (true) {
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                    break;
                }
                int asteroidSize = Math.abs(asteroid);
                if (stack.peek() > asteroidSize) {
                    break;
                }
                if (stack.peek() == asteroidSize) {
                    stack.pop();
                    break;
                }
                stack.pop();
            }
        }
        int[] output = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            output[i] = stack.pop();
        }
        return output;
    }
}
