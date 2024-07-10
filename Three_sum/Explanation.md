# 3 sum
#### Given an integer array nums, return all the triplets ```[nums[i], nums[j], nums[k]]``` such that ```i != j```, ```i != k```, and ```j != k```, and ```nums[i] + nums[j] + nums[k] == 0```.

## First Solution

```java
private static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> answerList = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
        for (int j = i + 1; j < nums.length - 1; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> combinationList = Arrays.asList(nums[i], nums[j], nums[k]);
                    Collections.sort(combinationList);
                    if (!answerList.contains(combinationList))
                        answerList.add(combinationList);
                }
            }
        }
    }
    return answerList;
}
```
This solution iterates through all possibilities of triplets within the given array, checking the sum for every single one, even duplicates, and if it equals 0, sorts the triplet and checks if it's already in the answerList and if not adds it. Then, it returns the List of Lists containing all the triplets that sum up to 0. It's not a good solution since the complexity is O(n^3), going through the entire array 3 times (not exactly 3 times since the loop gets smaller throughout the exectuion so the overall complexity would be a little lower)
<br>
</br>

## Improved Solution

```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> answerList = new ArrayList<>();
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i-1]) continue;
        int left = i + 1;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            if (sum == 0) {
                answerList.add(Arrays.asList(nums[i], nums[left], nums[right]));

                while (left < right && nums[left] == nums[left+1]) left++;
                while (left < right && nums[right] == nums[right-1]) right--;

                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }

        }
    }
    return answerList;
}
```
This solution begins by sorting the given array to use a two-pointer method. Using a loop to iterate through the array, with the variable ```i``` being the first element in the triplet, going until ```i < nums.length - 2``` because this way there's always a possible triplet. In the loop, duplicates are skipped by checking if the current ```i``` element is the same as the previous. The two-pointer technique works setting to pointers for each value of ```i```, ```left``` being the element after ```i``` and ```right``` beign the last element. Then it enters a loop while ```left < right``` in which the sum of the three elements is calculated and, if it's 0, it's added to answerList and both pointers move inward, and if the sum is not 0, it checks wether to increment the left value of decrement the right value so that the sum gets closer to 0. After a valid triplet, the algorithm skips duplicates by checking if the next value is equal to the current and skipping it in this case. Complexity is O(n^2) since the first loop runs ```n``` times and the two-pointer also runs ```n``` times.