"""
Best Time to Buy and Sell Stock
"""
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



"""
Find All Numbers Disappeared in an Array
"""
class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        S = set(nums)
        nSet = set()
        for i in range(len(nums)):
            nSet.add(i+1)
        resultSet = nSet - S
    
        return list(resultSet)



"""
Majority Element
"""
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        numset = set(nums)
        for i in numset:
            if nums.count(i) > len(nums)/2:
                return i



"""
Move Zeroes
"""
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        for i in nums:
            if i==0:
                nums.remove(i)
                nums.append(i)
            


"""
Single Number
"""
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        for i in nums:
            if (nums.count(i) == 1):
                return i



"""
Two Sum
"""
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        for i in range(len(nums) - 1): 
            for j in range(i+1, len(nums)):
                if target == nums[i] + nums[j]:
                    return i,j
        return []

