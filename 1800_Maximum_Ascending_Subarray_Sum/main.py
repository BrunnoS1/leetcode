class Solution:
    def maxAscendingSum(self, nums: list[int]) -> int:
        sum = 0
        currentSum = nums[0]
        for i in range(len(nums)-1):
            if (nums[i+1] > nums[i]):
                currentSum += nums[i+1]
            else:
                sum = max(sum, currentSum)
                currentSum = nums[i+1]
        return max(sum, currentSum)
    
sol = Solution()
print(sol.maxAscendingSum([10,20,30,5,10,50])) #65
print(sol.maxAscendingSum([10,20,30,40,50])) #150
print(sol.maxAscendingSum([12,17,15,13,10,11,12])) #33
