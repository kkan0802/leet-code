class Solution {
   static Map<Character, Character> hashmap = new HashMap<>();

    static {
        hashmap.put('(', ')');
        hashmap.put('[', ']');
        hashmap.put('{', '}');
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            Character token = s.charAt(i);

            if (hashmap.containsKey(token)) {
                stack.add(token);
            } else if (hashmap.containsValue(token)) {
                if (stack.isEmpty() || !hashmap.get(stack.pop()).equals(token)) {
                    return false;
                } 
            } 
        }
        
        return stack.isEmpty();
    }
}
