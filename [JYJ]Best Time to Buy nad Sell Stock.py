class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        largest_profit = 0
        min_prices = prices[0]
        for i in range(1,len(prices)):
            if prices[i] - min_prices > largest_profit:
                largest_profit = prices[i] - min_prices
            if prices[i] < min_prices:
                min_prices = prices[i]
        return largest_profit