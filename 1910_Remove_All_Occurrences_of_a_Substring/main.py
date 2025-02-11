class Solution(object):
    def removeOccurrences(self, s, part):
        """
        :type s: str
        :type part: str
        :rtype: str
        """
        while s.find(part) > -1:
            #if there is still occurences of part
            s = s[:s.find(part)] + s[s.find(part) + len(part):]
            #string = string from start to where part first appears\
            # + where part ends(where it starts+length) until the end
        return s
    
sol = Solution()
print(sol.removeOccurrences("daabcbaabcbc", "abc"))
print(sol.removeOccurrences("axxxxyyyyb", "xy"))