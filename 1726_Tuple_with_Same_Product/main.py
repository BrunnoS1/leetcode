class Solution(object):
    def tupleSameProduct(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        productMap = {}
        for i in range(len(nums)-1):
            for j in range(i+1, len(nums)):
                product = nums[i] * nums[j]
                if product in productMap:
                    productMap[product] = productMap[product] + 1
                else:
                    productMap[product] = 1
        count = 0
        for key in productMap:
            freq = productMap[key]
            if freq > 1:
                count += ((freq -1) * freq / 2) * 8
        return count



sol = Solution()
print(sol.tupleSameProduct([2,3,4,6]))
# dicio = {1: 15, 2: 30}
# print(dicio.keys())

