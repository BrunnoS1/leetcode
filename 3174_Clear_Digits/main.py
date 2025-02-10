class Solution(object):
    def clearDigits(self, s):
        """
        :type s: str
        :rtype: str
        """
        i = 0
        while i < len(s):
            if (s[i].isdigit()):
                s = s[: i-1] + s[i+1:]
                i -= 2
            i += 1
        return s
    
sol = Solution()
print(sol.clearDigits("abc"))
print(sol.clearDigits("cb34"))