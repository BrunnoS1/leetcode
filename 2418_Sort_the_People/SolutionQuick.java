import java.util.HashMap;
import java.util.Map;

public class SolutionQuick {
    // solution with quicksort 5ms runtime
    public static String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> nameHeightMap = new HashMap<>();
        for (int i = 0; i < heights.length; i++)
            nameHeightMap.put(heights[i], names[i]);

        // System.out.println("\noriginal");
        // for (int height : heights) {
        // System.out.print(height + " ");
        // }

        quickSort(heights, 0, heights.length - 1);

        // System.out.println("\nordered");
        // for (int height : heights) {
        // System.out.print(height + " ");
        // }

        String[] orderedNames = new String[heights.length];
        for (int i = 0; i < heights.length; i++) {
            orderedNames[i] = nameHeightMap.get(heights[i]);
        }

        System.out.println("\nordered names");
        for (String name : orderedNames) System.out.print(name + " ");

        return orderedNames;
    }

    private static int partition(int[] array, int low, int high) {
        int x = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] >= x) {
                i++;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        i++;
        array[high] = array[i];
        array[i] = x;
        return i;
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int q = partition(array, low, high);

            quickSort(array, low, q - 1);
            quickSort(array, q + 1, high);
        }
    }

    public static void main(String[] args) {
        String[] names = { "A", "B", "C", "D", "E", "F", "G" };
        int[] heights = { 51, 11, 32, 4, 6, 999, 321 };
        sortPeople(names, heights);
    }
}
