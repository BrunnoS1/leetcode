class Solution2 {
    private static String reverseParentheses(String s) {
        int index = s.lastIndexOf('(');
        while (index != -1) {
            int end = index;
            while ( s.charAt(end) != ')') end++;
            String reversedSubString = "";
            for (int j = end - 1; j > index; j--) {
                reversedSubString += s.charAt(j);
            }
            s = s.substring(0, index) + reversedSubString + s.substring(end+1, s.length());
            index = s.lastIndexOf('(');
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "(ed(et(oc))el)";
        System.out.println(reverseParentheses(s));
    }
}