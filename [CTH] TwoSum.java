class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i); //value, index
        }

        for (int i=0; i<nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                int keyIdx = map.get(key);
                if (i == keyIdx) {
                    continue;
                }

                return new int[] {i, keyIdx};
            }
        }
        return new int[] {-1, -1};
    }
}