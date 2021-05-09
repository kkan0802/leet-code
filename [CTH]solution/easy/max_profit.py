from typing import List


class Solution:
    @staticmethod
    def max_profit(prices: List[int]) -> int:
        profit_max, low = 0, 999999

        for price in prices:
            if price > low:
                profit_max = max(profit_max, price - low)
            elif price < low:
                low = price

        return profit_max


if __name__ == '__main__':
    print(Solution.max_profit([7, 1, 5, 3, 6, 4]))
    print(Solution.max_profit([7, 6, 4, 3, 1]))
