package me.asher.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FunctionDevelopmentTest {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();

        List<Integer> elapsed = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int k = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            elapsed.add(k);
        }

        int m = elapsed.get(0);
        int count = 0;
        for (int cur : elapsed) {
            if (cur <= m) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                m = cur;
            }
        }

        if (count != 0) {
            answer.add(count);
        }

        return answer.stream().mapToInt(r -> r).toArray();
    }

    @Test
    void testSolution() {
        Assertions.assertArrayEquals(new int[]{2, 1}, solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        Assertions.assertArrayEquals(new int[]{1, 3, 2}, solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }
}
