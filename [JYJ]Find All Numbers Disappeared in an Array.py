class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        S = set(nums)
        nSet = set()
        for i in range(len(nums)):
            nSet.add(i+1)
        resultSet = nSet - S
        
        return list(resultSet)