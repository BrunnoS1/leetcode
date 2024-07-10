
# def twoSum(nums, target):
#     answer = 0
#     for i in range(len(nums)):
#         test_index = 0
#         if answer != 0:
#             break
#         while test_index < len(nums) and answer == 0:
#             if i != test_index:
#                 if (nums[i] + nums[test_index]) == target:
#                     answer = [i, test_index]
#             test_index += 1
#     return answer


def twoSum(nums: list[int], target: int) -> list[int]:
    numToIndex = {}
    for i in range(len(nums)):
        if target - nums[i] in numToIndex:
            return [numToIndex[target - nums[i]], i]
        numToIndex[nums[i]] = i
    return []

print(twoSum([2,7,11,15], 9))