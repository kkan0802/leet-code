package donaldAlgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class Algorithm1 {
	
//1. twoSum
    public int[] twoSum(int[] nums, int target) {
        int[] result = {0,0}; 
    	int x = 0;
        int y = 0;
        for(int i = 0; i < nums.length ; i++) {
        	for(int j = i+1 ; j < nums.length ; j++) {
        		int temp = 0;
        		temp = nums[i] + nums[j];
        		if(temp == target) {
        			x = i;
        			y = j;
        		}
        	}
        }
    	result[0] = x;
    	result[1] = y;
    	
        return result;
    }

//20. Valid Parentheses
    public boolean isValid(String s) {
    	boolean result = false;
    	
    	char[] array = s.toCharArray();
        
        Stack<String> stack = new Stack<>();
        
        for(int i = 0 ; i < array.length ; i ++) {
        	if(stack.empty()) {
        		stack.push(Character.toString(array[i]));
        	}
        	else if(stack.peek().equals("(")) {
            	if(Character.toString(array[i]).equals(")")) {
            		stack.pop();
            	}
            	else {
            		stack.push(Character.toString(array[i]));
            	}
            }
            else if(stack.peek().equals("[")) {
            	if(Character.toString(array[i]).equals("]")) {
            		stack.pop();
            	}
            	else {
            		stack.push(Character.toString(array[i]));
            	}
            }
            else if(stack.peek().equals("{")) {
            	if(Character.toString(array[i]).equals("}")) {
            		stack.pop();
            	}
            	else {
            		stack.push(Character.toString(array[i]));
            	}
            }
            else {
                stack.push(Character.toString(array[i]));
            }
        }
    	
        if(stack.empty()) result = true;
    	
    	return result;
    }
    
//215. Kth Largest Element in an Array
    public int findKthLargest(int[] nums, int k) {
        for(int i = 0 ; i < nums.length ;  i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                if(nums[i] < nums[j]) {
                    int temp = 0 ;
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
            }
        }
        
        return nums[k-1];
    }
    
//169. Majority Element
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		int value = map.get(nums[i]) + 1;
        		map.put(nums[i], value);
        	}else {
        		map.put(nums[i], 1);
        	}
        }
        int max = 0;
        int ans = 0;
        for(int key : map.keySet()) {
        	if(map.get(key) >= max) {
                ans = key;
        		max = map.get(key);
        	}
        }
        
        return ans;
        
    }
    
//283. Move Zeroes
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> number = new ArrayList<>();
        int zeroCount = 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
        	if(nums[i] == 0) {
        		zeroCount++;
        	}else {
        		number.add(nums[i]);
        	}
        }
        
        for(int i = 0; i < zeroCount ; i++) {
        	number.add(0);
        }
        
        for(int i = 0 ; i < nums.length ; i++) {
        	nums[i] = number.get(i);
        }
    }
    // Move Zeroes - v2
    public void moveZeroes2(int[] nums) {
        int[] ans = new int[nums.length];
        for(int i = 0 ; i < ans.length ; i++){
            ans[i] = nums[i];
        }
        
        for(int i = 0,  s = 0, e = nums.length - 1; i < ans.length ; i++) {
        	if(ans[i] == 0) {
                nums[e--] = ans[i];
        	}else {
                nums[s++] = ans[i];
        	}
        }
    }
    
//338. Counting Bits
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i = 0 ; i < n+1 ; i++) {
            int t = i;
            int q = 0;
            int r = 0;
            int cnt = 0;
            
            while(t > 1){
                q = t%2;
                t = t/2;
                if(q == 1) cnt++;
            }
            if(t == 1) cnt++;
            ans[i] = cnt;
            
        }
        
        return ans;
    }
    
//136. Single Number
    public int singleNumber(int[] nums) {
        int result = 0;
        HashMap<String, String> m = new HashMap<String, String>();
        
        for(int i = 0; i<nums.length; i++){
            m.put(Integer.toString(i),"N");
        }
        
        for(int i = 0; i < nums.length; i++){
            if(m.get(Integer.toString(i)).equals("Y")) break;
            else {
                for(int j = 0; j < nums.length; j++){
                    if(i==j) break;
                    else {
                        if(nums[i] == nums[j]) {
                            m.put(Integer.toString(i),"Y");
                            m.put(Integer.toString(j),"Y");
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i<nums.length; i++){
            if(m.get(Integer.toString(i)).equals("N")) result = nums[i];
        }
        
        return result;
    }
    
    //Single Number - v2
    public int singleNumber2(int[] nums) {
        int result = 0;
        
        int[] check = new int[nums.length];
        
        for(int i = 0; i<check.length; i++){
        	check[i] = 0;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(check[i] == 1) break;
            else {
                for(int j = 0; j < nums.length; j++){
                    if(i==j) break;
                    else {
                        if(nums[i] == nums[j]) {
                        	check[i] = 1;
                        	check[j] = 1;
                        }
                    }
                }
            }
        }
        
        for(int i = 0; i<nums.length; i++){
            if(check[i] == 0) result = nums[i];
        }
        
        return result;
    }
}
