# output = k (array lenght) and array

def removeElement(nums, val):
    count = 0
    while count < len(nums):
        while nums[count] == val and count < len(nums):
            nums.pop(count)
        count += 1
    k = len(nums)
    return k, nums
    

nums = [3,2,2,3]
val = 2

print(removeElement(nums, val))