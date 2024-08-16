import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        // get first and last elements of first array and initialize maxDistance
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            // update maxDistance to be the highest of current value
            // or last element of current array - current min value
            // or current max value - first element of current array
            maxDistance = Math.max(maxDistance, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            maxDistance = Math.max(maxDistance, Math.abs(max - arrays.get(i).get(0)));
            
            // update min and max to new values if needed
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
        }

        return maxDistance;
    }
}