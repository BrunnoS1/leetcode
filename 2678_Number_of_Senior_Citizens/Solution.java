class Solution {
    public int countSeniors(String[] details) {
        int seniorCounter = 0;
        for (String passengerDetails : details) {
            if (Integer.parseInt(passengerDetails.substring(11,13)) > 60) seniorCounter++;
        }
        return seniorCounter;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(solution.countSeniors(details));
    } 
}