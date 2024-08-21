class Solution {
    public static int strangePrinter(String s) {
        // not optimal operation count in some cases
        StringBuilder printed = new StringBuilder();
        printed.setLength(s.length());
        int end = s.length()-1;
        int start = 0;
        int operations = 0;

        while (!printed.toString().equals(s)) {
            char firstChar = s.charAt(start);
            while (s.charAt(end) != firstChar) end--;
        
            for (int j = start; j <= end; j++) {
                printed.setCharAt(j, firstChar);
            }
            
            end = s.length()-1;
            while (start < s.length() && s.charAt(start) == firstChar) start++;
            operations++;
            System.out.println(operations + " - " + printed);
        }

        return operations;
    }

    public static void main(String[] args) {
        System.out.println(strangePrinter("abcabcabc"));
    }
}