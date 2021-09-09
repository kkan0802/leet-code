package programmers;

import java.util.Arrays;

public class StockPrice {

    public static int[] solution(int[] prices) {

        int[] answer = new int[prices.length];
        
        for (int i = 0; i < prices.length; i++) {
            for (int p = i + 1; p < prices.length; p++) {
                answer[i]++;
                if (prices[i] > prices[p]) {
                    break;
                } 
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3}))); // [4, 3, 1, 1, 0]
        System.out.println(Arrays.toString(solution(new int[]{5, 8, 6, 2, 4, 1}))); // [3, 1, 1, 2, 1, 0]
    }
}
