package me.asher.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class HIndexTest {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;
        int h = Arrays.stream(citations).max().getAsInt();

        while (h > 0) {
            int finalH = h;
            if (Arrays.stream(citations).filter(i -> i >= finalH).count() >= h &&
                    Arrays.stream(citations).filter(i -> i < finalH).count() <= h) {
                break;
            }
            h--;
        }

        return h;
    }

    @Test
    void testSolution() {
        Assertions.assertEquals(0, solution(new int[]{0, 0, 0, 0, 0}));
        Assertions.assertEquals(3, solution(new int[]{3, 0, 6, 1, 5}));
    }
}
