package me.asher.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

class DoublePqTest {

    private static final String EMPTY_STRING = " ";
    private static final String INSERT_SIGNAL = "I";
    private static final String DELETE_SIGNAL = "D";
    private static final Integer POLL_MAX_SIGNAL = 1;
    private static final Integer POLL_MIN_SIGNAL = -1;

    public int[] solution(String[] operations) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (String op : operations) {
            String[] args = op.split(EMPTY_STRING);
            String opCode = args[0];
            Integer value = Integer.parseInt(args[1]);

            if (opCode.equals(INSERT_SIGNAL)) {
                pq.offer(value);
            } else if (opCode.equals(DELETE_SIGNAL)) {
                if (value.equals(POLL_MAX_SIGNAL)) {
                    pollMax(pq);
                } else if (value.equals(POLL_MIN_SIGNAL)) {
                    pq.poll();
                }
            }
        }

        if (pq.isEmpty()) {
            return new int[]{0, 0};
        }

        while (!pq.isEmpty()) {
            Integer value = pq.poll();
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        return new int[]{max, min};
    }

    private void pollMax(PriorityQueue<Integer> pq) {
        PriorityQueue<Integer> upq = new PriorityQueue<>(Comparator.reverseOrder());
        upq.addAll(pq);
        pq.clear();
        upq.poll();
        pq.addAll(upq);
    }

    @Test
    void testSolution() {
        Assertions.assertArrayEquals(new int[]{0, 0}, solution(new String[]{"I 16","D 1"}));
        Assertions.assertArrayEquals(new int[]{7, 5}, solution(new String[]{"I 7","I 5","I -5","D -1"}));
    }
}
