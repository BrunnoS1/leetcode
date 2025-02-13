class Solution(object):
    def minOperations(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        #using recursion, wont work for big arrays
        #looks cool
        #bad cause of running through the whole array for every call
        n = len(nums)
        greaterk = True
        for i in range(n):
            #check if nums are greater than k
            if nums[i] < k:
                greaterk = False
                break

        if not greaterk and n > 1:
            #array for the indexes of the 2 smallest numbers
            smallest = [0, 1]
            if nums[smallest[0]] > nums[smallest[1]]:
                #make first smallest number < second
                smallest[0] = 1
                smallest[1] = 0

            if n > 2:
                for i in range(2, n):
                    #find the actual smallest
                    if nums[i] < nums[smallest[1]]:
                        if nums[i] < nums[smallest[0]]:
                            smallest[1] = smallest[0]
                            smallest[0] = i
                        else:
                            smallest[1] = i
            if smallest[0] > smallest[1]:
                #element that appears first should be popped first
                temp = smallest[0]
                smallest[0] = smallest[1]
                smallest[1] = temp
            #remove 2 smallest and append
            x,y = nums.pop(smallest[0]), nums.pop(smallest[1]-1)
            nums.append(min(x, y) * 2 + max(x, y))
            operations = 1 + self.minOperations(nums, k)
            return operations

        return 0
    
sol = Solution()
print(sol.minOperations([2,11,10,1,3], 10))
print(sol.minOperations([1,1,2,4,9], 20))
