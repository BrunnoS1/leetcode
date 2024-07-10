def lengthOfLongestSubstring(s):
        """
        :type s: str
        :rtype: int
        """
        char_index = 0
        length = 0
        substring = ""
        for character in s:
            test_substring = character
            test_length = 1
            test_char_index = char_index
            while test_char_index+1 < len(s):
                if s[test_char_index+1] not in test_substring:
                    test_substring += s[test_char_index+1]
                    test_length += 1
                else:
                    break
                test_char_index += 1
            if test_length > length:
                length = test_length
                substring = test_substring
            char_index += 1
        print(f"The answer is {substring}, with the length of {length}.")
        return length

print(lengthOfLongestSubstring("pwwkew"))