class Solution:
    def numOfSubarrays(self, arr: list[int]) -> int:
        oddSum = []
        used = [False] * len(arr)
        self.generateSubArrays(arr, [], oddSum, used)
        return len(oddSum)
    
    def generateSubArrays(self, arr: list[int], currentSub: list[int], oddSum: list[int], used: list[bool]):
        if (sum(currentSub) % 2 != 0) and currentSub not in oddSum:
            oddSum.append(currentSub)
        if len(currentSub) == len(arr):
            return
        for index in range(len(arr)):
            if not used[index]:
                newCurrent = currentSub
                used[index] = True
                newCurrent.append(arr[index])
                self.generateSubArrays(arr, newCurrent, oddSum, used)
                used[index] = False