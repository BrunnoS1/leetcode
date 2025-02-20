class Solution:
    def getHappyString(self, n: int, k: int) -> str:
        #array to keep all generated happy strings
        strings = []
        self.happyStringGenerator(strings, n, k, "")
        if len(strings) < k:
            return ""
        else:
            return strings[-1]

    def happyStringGenerator(self, strings: list, n: int, k: int, current_string: str):
        #already enough happy strings
        if len(strings) == k:
            return
        
        if len(current_string) == n:
            strings.append(current_string)
            return
        
        #generate all possible happy strings, combining a, b and c
        for char in ['a', 'b', 'c']:
            if not current_string or current_string[-1] != char:
                self.happyStringGenerator(strings, n, k, current_string + char)

sol = Solution()
print(sol.getHappyString(1,3))
print(sol.getHappyString(1,4))
print(sol.getHappyString(3,9))
