import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> billCount = new HashMap<>() {
            {
                put(5, 0);
                put(10, 0);
            }
        };

        for (int bill : bills) {
            if (bill == 5) billCount.put(5, billCount.get(5)+1);
            else if (bill == 10) {
                if (billCount.get(5) == 0) return false;
                billCount.put(5, billCount.get(5) - 1);
                billCount.put(bill, billCount.get(bill) + 1);
            } else if (bill == 20) {
                if (billCount.get(10) == 0) {
                    if (billCount.get(5) < 3) return false;
                    billCount.put(5, billCount.get(5) - 3);
                } else {
                    if (billCount.get(5) == 0) return false;
                    billCount.put(10, billCount.get(10) - 1);
                    billCount.put(5, billCount.get(5) - 1);
                }
            }
        }
        return true;
    }
}