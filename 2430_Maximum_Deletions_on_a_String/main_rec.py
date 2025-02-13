#doesnt work if string is too big
class Solution(object):
    def deleteString(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            #base case = if string is empty
            return 0

        max_operations = 1

        for i in range(1, len(s) // 2 + 1):
            #iterate through all possible lengths of prefixes
            #check if prefix of length i equals to next i characters
            if s[:i] == s[i:2*i]:
                #recursively test with new string (removed first i elements) 
                operations = 1 + self.deleteString(s[i:])
                max_operations = max(max_operations, operations)

        return max_operations
    
sol = Solution()
# print(sol.deleteString("abcabcdabc"))
# print(sol.deleteString("aaabaab"))
# print(sol.deleteString("aaaaa"))