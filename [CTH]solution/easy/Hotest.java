package programmers;

import java.util.PriorityQueue;

public class Hotest {

    public static int solution(int[] scovilles, int K) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int scoville: scovilles) {
            pq.offer(scoville);
        }

        int count = 0;
        while (!pq.stream().allMatch(p -> p >= K)) {
            if (pq.size() < 2) {
                return -1;
            } else {
                pq.offer(pq.poll() + (pq.poll() * 2));
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

}
