from typing import List


class Solution:
    @staticmethod
    def max_sub_array(nums: List[int]) -> int:
        dp = [0] * len(nums)
        for i in range(len(nums)):
            dp[i] = max(dp[i - 1] + nums[i], nums[i])
        return max(dp)


if __name__ == '__main__':
    print(Solution.maxSubArray([-2, 1, -3, 4, -1, 2, 1, -5, 4]))
    print(Solution.maxSubArray([1]))
    print(Solution.maxSubArray([5, 4, -1, 7, 8]))
