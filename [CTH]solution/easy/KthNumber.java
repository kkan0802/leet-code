package me.asher.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class KthNumberTest {

    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int[] command : commands) {
            int[] temp = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(temp);
            answer.add(temp[command[2] - 1]);
        }

        return answer.stream().mapToInt(r -> r).toArray();
    }

    @Test
    void testSolution() {
        int[] res = solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        Assertions.assertArrayEquals(new int[]{5, 6, 3}, res);
    }

}
