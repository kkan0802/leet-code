package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MockExam {

    private static final int[] SUPO1_PATTERN = new int[]{1, 2, 3, 4, 5};
    private static final int[] SUPO2_PATTERN = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] SUPO3_PATTERN = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public static int[] solution(int[] answers) {

        Map<Integer, Integer> participants = new HashMap<>();
        participants.put(1, 0);
        participants.put(2, 0);
        participants.put(3, 0);

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];

            if (answer == SUPO1_PATTERN[i % SUPO1_PATTERN.length]) {
                int value = participants.get(1);
                participants.put(1, value + 1);
            }

            if (answer == SUPO2_PATTERN[i % SUPO2_PATTERN.length]) {
                int value = participants.get(2);
                participants.put(2, value + 1);
            }

            if (answer == SUPO3_PATTERN[i % SUPO3_PATTERN.length]) {
                int value = participants.get(3);
                participants.put(3, value + 1);
            }
        }

        long max = participants.values().stream().max(Comparator.naturalOrder()).get();

        return participants.entrySet().stream().filter(e -> e.getValue() == max).map(Map.Entry::getKey)
                .collect(Collectors.toList()).stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        //        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 1})));
        //        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

}
