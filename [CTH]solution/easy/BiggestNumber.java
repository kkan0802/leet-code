package me.asher.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

class MyNumber implements Comparable<MyNumber> {

    private final Integer number;

    public MyNumber(Integer number) {
        this.number = number;
    }

    @Override
    public int compareTo(MyNumber o) {
        String o1 = String.valueOf(this.number);
        String o2 = String.valueOf(o.number);
        return Integer.valueOf(o1 + o2).compareTo(Integer.valueOf(o2 + o1));
    }

    public String toString() {
        return String.valueOf(this.number);
    }
}

class BiggestNumberTest {

    public String solution(int[] numbers) {
        String answer =  Arrays.stream(numbers)
                .mapToObj(MyNumber::new)
                .sorted(Comparator.reverseOrder())
                .map(MyNumber::toString)
                .reduce("", String::concat);

        if (answer.charAt(0) == '0') {
            return "0";
        } else {
            return answer;
        }
    }

    @Test
    void testSolution() {
        Assertions.assertEquals("70000", solution(new int[]{70, 0, 0, 0}));
        Assertions.assertEquals("1000000", solution(new int[]{0, 0, 1000, 0}));
        Assertions.assertEquals("21221", solution(new int[]{21, 212}));
        Assertions.assertEquals("0", solution(new int[]{0, 0, 0}));
        Assertions.assertEquals("6210", solution(new int[]{6, 10, 2}));
        Assertions.assertEquals("9534330", solution(new int[]{3, 30, 34, 5, 9}));
    }
}
