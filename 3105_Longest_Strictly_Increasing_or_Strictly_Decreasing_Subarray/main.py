class Solution:
    def longestMonotonicSubarray(self, nums: list[int]) -> int:
        highestLength = 1
        increasing = None
        currentLength = 1
        for i in range(len(nums)-1):
            if (nums[i+1] > nums[i]):
                if not increasing:
                    highestLength = max(currentLength, highestLength)
                    currentLength = 1
                currentLength += 1
                increasing = True
            elif (nums[i+1] < nums[i]):
                if increasing:
                    highestLength = max(currentLength, highestLength)
                    currentLength = 1
                currentLength += 1
                increasing = False
            else: #if nums are equal
                highestLength = max(currentLength, highestLength)
                currentLength = 1
                increasing = None
        return max(highestLength, currentLength)
        
sol = Solution()
print(f"Output = {sol.longestMonotonicSubarray([1,4,3,3,2])}")