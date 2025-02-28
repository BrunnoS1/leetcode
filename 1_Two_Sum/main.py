class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        num_index = {}
        for index in range(len(nums)):
            rem = target - nums[index]
            
            if rem in num_index:
                return [index, num_index[rem]]

            num_index[nums[index]] = index
        
        return []
        