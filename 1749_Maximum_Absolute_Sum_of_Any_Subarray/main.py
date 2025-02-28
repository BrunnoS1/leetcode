class Solution:
    def maxAbsoluteSum(self, nums: list[int]) -> int:
        maxSum = 0
        prefixSum = 0
        min_prefixSum = float('inf')
        max_prefixSum = float('-inf')

        for num in nums:
            prefixSum += num

            min_prefixSum = min(min_prefixSum, prefixSum)
            max_prefixSum = max(max_prefixSum, prefixSum)

            if prefixSum >= 0:
                maxSum = max(maxSum, max(prefixSum, prefixSum - min_prefixSum))
            elif prefixSum <= 0:
                maxSum = max(maxSum, max(abs(prefixSum), abs(prefixSum - max_prefixSum)))

        return maxSum

    
sol = Solution()
# print(sol.maxAbsoluteSum([1,-3,2,3,-4]))
print(sol.maxAbsoluteSum([-1]))