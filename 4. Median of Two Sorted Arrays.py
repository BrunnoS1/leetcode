def findMedianSortedArrays(nums1, nums2):
    merged_array = nums1 + nums2
    merged_array.sort()
    if len(merged_array)%2 == 0:
        #check if array length is even
        middle_position = (len(merged_array)-1)//2
        return (merged_array[middle_position] + merged_array[middle_position+1]) / 2
    else:
        middle_position = (len(merged_array)-1)//2
        return (merged_array[middle_position])
print(findMedianSortedArrays([1,2],[3,4]))