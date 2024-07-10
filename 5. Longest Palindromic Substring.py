def longestPalindrome(s):
    """
    :type s: str
    :rtype: str
    """
    if len(s) <= 1:
        return s
    # start looking for a palindrome through it's middle point
    def count_from_center(left, right):
        while left >= 0 and right < len(s) and s[left] == s[right]:
            left -= 1
            right += 1
        return s[left+1 : right]
    
    longest = ""
    # test "middle points" for odd or even string lengths
    for i in range(len(s)-1):
        odd = count_from_center(i,i)
        even = count_from_center(i, i+1)

        if len(odd) > len(longest):
            longest = odd
        if len(even) > len(longest):
            longest = even

    return longest