import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {

	public static void main(String[] args) {

		Solution solution = new Solution();

		/*
		 * 1. Valid Parentheses
		 * 
		 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
		 * ']', determine if the input string is valid.
		 * 
		 * Example 1:
		 * 
		 * Input: s = "()" 
		 * Output: true 
		 * 
		 * Example 2:
		 * 
		 * Input: s = "()[]{}" 
		 * Output: true 
		 * 
		 * Example 3:
		 * 
		 * Input: s = "(]" 
		 * Output: false 
		 * 
		 * Example 4:
		 * 
		 * Input: s = "([)]" 
		 * Output: false 
		 * 
		 * Example 5:
		 * 
		 * Input: s = "{[]}" 
		 * Output: true
		 */
		
		String s = "([)]";
		boolean output = solution.isValid(s);
		
		System.out.println("Output : " + output);
	}

	static class Solution {

		private static final String OPEN_BRACKETS = "([{";
	    private static final String CLOSING_BRACKETS = ")]}";

	    public boolean isValid(String s) {
	        Deque<Character> stack = new ArrayDeque<>();

	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);

	            if (isOpeningBracket(c)) {
	                stack.push(c);
	            } else {
	                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
	                    return false;
	                }
	            }
	        }

	        return stack.isEmpty();
	    }

	    private boolean isOpeningBracket(char c) {
	        return OPEN_BRACKETS.indexOf(c) != -1;
	    }

	    private boolean isMatching(char open, char close) {
	        return OPEN_BRACKETS.indexOf(open) == CLOSING_BRACKETS.indexOf(close);
	    }
	}
}
