class Solution(object):
    def minOperations(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        #sort array, get 2 first, do the operation, insert it at the right
        #position to keep array sorted, loop until smallest number >= k
        operations = 0
        nums.sort()
        while(nums[0] < k):
            x,y = nums.pop(0), nums.pop(0)
            new_element = min(x, y) * 2 + max(x, y)
            #binary search to find where to insert the new element and keep sorted
            left, right = 0, len(nums)
            while left < right:
                mid = (left + right) // 2
                if nums[mid] < new_element:
                    left = mid + 1
                else:
                    right = mid
            nums.insert(left, new_element)
            operations += 1
        
        return operations
    
sol = Solution()
print(sol.minOperations([2,11,10,1,3], 10))
print(sol.minOperations([1,1,2,4,9], 20))
