class Solution:
    #generate every possible binary string until it finds one not in nums
    def findDifferentBinaryString(self, nums: list[str]) -> str:
        return self.generateBinaryStrings(nums,"", len(nums[0]))

    def generateBinaryStrings(self, nums:list[str], currentString: str, length: int) -> str:
        if len(currentString) == length:
            if currentString not in nums:
                return currentString
            return None
            
        for char in ['0', '1']:
            result = self.generateBinaryStrings(nums, currentString + char, length)
            if result:
                return result
            
        return None

sol = Solution()
print(sol.findDifferentBinaryString(["01","10"]))
print(sol.findDifferentBinaryString(["00","01"]))
print(sol.findDifferentBinaryString(["111","011","001"]))