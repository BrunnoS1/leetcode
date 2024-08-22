import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int findComplement(int num) {
        List<Integer> binaryNum = getBinary(num);
        for (int i = 0; i < binaryNum.size(); i++) {
            binaryNum.set(i, 1 - binaryNum.get(i));
        }
        return binaryToDecimal(binaryNum);
    }

    private List<Integer> getBinary(int num) {
        List<Integer> binaryArray = new ArrayList<>();
        while (num > 0) {
            binaryArray.add(num % 2);
            num /= 2;
        }
        Collections.reverse(binaryArray);
        return binaryArray;
    }

    private int binaryToDecimal(List<Integer> binaryNum) {
        int number = 0;
        int n = binaryNum.size() - 1;
        for (int i = 0; i < binaryNum.size(); i++, n--) {
            number += binaryNum.get(i) * Math.pow(2, n);
        }
        return number;
    }
}
