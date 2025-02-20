class Solution:
    def numTilePossibilities(self, tiles: str) -> int:
        sequences = set()
        used = [False] * len(tiles)

        self.getSequences(tiles, "", used, sequences)
        return len(sequences) - 1
    
    def getSequences(self, tiles: str, current: str, used: list, sequences: set) -> None:
        sequences.add(current)

        for position, char in enumerate(tiles):
            if not used[position]:
                used[position] = True
                self.getSequences(tiles, current + char, used, sequences)
                used[position] = False

sol = Solution()
print(sol.numTilePossibilities("AAB"))
print(sol.numTilePossibilities("AAABBC"))
print(sol.numTilePossibilities("V"))