import java.util.Collections;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Enumeration;

class Solution {
    public static int majorityElement(int[] nums) {
        int majorityElement = 0;
        Hashtable<Integer, Integer> numbersHashtable = new Hashtable<Integer, Integer>();
        for (int num : nums) {
            numbersHashtable.put(num, numbersHashtable.getOrDefault(num,0)+1);
        }
        int mostOccurences = Collections.max(numbersHashtable.values());

        Enumeration<Integer> keys = numbersHashtable.keys();
        
        while (keys.hasMoreElements()) {
            int key = keys.nextElement();
            
            if (numbersHashtable.getOrDefault(key, -1) == mostOccurences)
                return key;
        }
        return majorityElement;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] numsString = line.replaceAll("[\\[\\]]", "").split(",");
        int[] nums = new int[numsString.length];
        int i = 0;
        for (String num : numsString) {
            nums[i] = Integer.parseInt(num);
            i++;
        }
        System.out.println(majorityElement(nums));
        sc.close();
    }
}