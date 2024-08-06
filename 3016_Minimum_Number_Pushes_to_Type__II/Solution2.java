import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minimumPushes(String word) {
        Map<Character, Integer> charToKeyMap = new HashMap<>();
        int mappedKeys = 0;
        int keyGroup = 1;

        for (char c : word.toCharArray()) {
            if (!charToKeyMap.containsKey(c)) {
                charToKeyMap.put(c, keyGroup);
                mappedKeys++;
                if (mappedKeys == 8) {
                    keyGroup++;
                    mappedKeys = 0;
                }
            }
        }

        int presses = 0;
        for (char c : word.toCharArray()) {
            presses += charToKeyMap.get(c);
        }
        return presses;
    }
}