class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        numset = set(nums)
        for i in numset:
            if nums.count(i) > len(nums)/2:
                return i