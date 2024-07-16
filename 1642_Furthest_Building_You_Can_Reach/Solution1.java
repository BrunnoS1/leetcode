import java.util.ArrayList;
import java.util.List;

class Solution1 {
    public static int furthestBuilding(int[] heights, int bricks, int ladders) {
        List<Integer> maxDiffs = new ArrayList<Integer>();
        int heightSum = 0;
        int i = 0;
        boolean enoughBricks = true;
        for (int j = 0; j < ladders; j++) {
            while (i < heights.length - 1 && enoughBricks) {
                if (heights[i] >= heights[i + 1])
                    i++;
                else {
                    heightSum += heights[i + 1] - heights[i];
                    maxDiffs.add(heights[i + 1] - heights[i]);
                    enoughBricks = heightSum < bricks;
                    if (enoughBricks)
                        i++;
                }
            }
            if (i < heights.length - 1) {
                maxDiffs.sort(null);
                heightSum -= maxDiffs.get(maxDiffs.size() - 1);
                maxDiffs.remove(maxDiffs.size() - 1);
                maxDiffs = maxDiffs.subList(0, maxDiffs.size());
                enoughBricks = true;
                i++;
            }
        }

        while (i < heights.length - 1 && enoughBricks) {
            if (heights[i] >= heights[i + 1])
                i++;
            else {
                heightSum += heights[i + 1] - heights[i];
                enoughBricks = heightSum < bricks;
                if (enoughBricks)
                    i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(furthestBuilding(new int[] { 17, 16, 5, 10, 10, 14, 7 }, 74, 6));
    }
}