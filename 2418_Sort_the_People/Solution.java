import java.util.HashMap;
import java.util.Map;

class Solution {
    // solution with bubble sort 18ms runtime
    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> nameHeightMap = new HashMap<>();
        for (int i = 0; i < heights.length; i++)
            nameHeightMap.put(heights[i], names[i]);

        for (int j = 0; j < heights.length - 1; j++) {
            for (int i = 0; i < heights.length - 1 - j; i++) {
                if (heights[i] < heights[i + 1]) {
                    int temp = heights[i];
                    heights[i] = heights[i + 1];
                    heights[i + 1] = temp;
                }
            }
        }

        String[] orderedNames = new String[heights.length];
        for (int i = 0; i < heights.length; i++) {
            orderedNames[i] = nameHeightMap.get(heights[i]);
        }

        System.out.println("\nordered names");
        for (String name : orderedNames) System.out.print(name + " ");

        return orderedNames;
    }

    public static void main(String[] args) {
        String[] names = { "A", "B", "C", "D", "E", "F", "G" };
        int[] heights = { 51, 11, 32, 4, 6, 999, 321 };
        sortPeople(names, heights);
    }
}