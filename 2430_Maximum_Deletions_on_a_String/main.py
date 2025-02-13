class Solution(object):
    def deleteString(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dp = [1] * (n + 1) #dp[i] means max operations for s[i:]

        #iterate backwards
        for i in range(n - 1, -1, -1):
            max_ops = 1 #minimum is 1 (entire string)
            
            #iterate through all possible prefix lengths (max is half)
            for length in range(1, (n-1)//2 + 1):
                if s[i:i+length] == s[i + length:i + 2*length]:
                    max_ops = max(max_ops, 1 + dp[i+length])
            

            dp[i] = max_ops
        
        return dp[0]
    
sol = Solution()
# print(sol.deleteString("abcabcdabc"))
# print(sol.deleteString("aaabaab")) 