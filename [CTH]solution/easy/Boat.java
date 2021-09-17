import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] people, int limit) {

        ArrayDeque<Integer> deque = Arrays.stream(people)
                .sorted().boxed().collect(Collectors.toCollection(ArrayDeque::new));

        int boatUseCount = 0;
        while (!deque.isEmpty()) {

            Integer max = deque.peekLast();
            Integer min = deque.peekFirst();

            if (max + min <= limit) {
                deque.pollLast();
                deque.pollFirst();
            } else {
                deque.pollLast();
            }

            boatUseCount++;
        }

        return boatUseCount;
    }
}
