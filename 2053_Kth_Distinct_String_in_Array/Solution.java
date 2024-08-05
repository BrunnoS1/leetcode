import java.util.HashMap;
import java.util.Map;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> stringCountMap = new HashMap<>();
        for (String string : arr) {
            stringCountMap.put(string, stringCountMap.getOrDefault(string, 0) + 1);
        }
        int count = 0;
        for (String string : arr) {
            if (stringCountMap.get(string) == 1) {
                count++;
                if (count == k) return string;
            }
        }
        return "";
    }
}