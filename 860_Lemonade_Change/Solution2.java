class Solution2 {
    //want to see the difference between using a map for this simple problem
    //instead of just using variables for counting bills
    public boolean lemonadeChange(int[] bills) {
        int fives = 0;
        int tens = 0;

        for (int bill : bills) {
            if (bill == 5) fives++;
            else if (bill == 10) {
                if (fives == 0) return false;
                fives--;
                tens++;
            } else { //bill == 20
                if (tens > 0 && fives > 0) {
                    fives--;
                    tens--;
                } else if (fives > 2) fives -= 3;
                else return false;
            }
        }
        return true;
    }
}