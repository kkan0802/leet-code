class Solution:
    @staticmethod
    def climb_stairs(n: int) -> int:
        dp = [0] * n
        for i in range(len(dp)):
            if i in (0, 1):
                dp[i] = i+1
                continue
            dp[i] = dp[i - 1] + dp[i - 2]
        return dp[-1]


if __name__ == '__main__':
    print(Solution.climb_stairs(1))
    print(Solution.climb_stairs(2))
    print(Solution.climb_stairs(3))
    print(Solution.climb_stairs(4))
    print(Solution.climb_stairs(5))
