public class Solution {
    public static int maximumGain(String s, int x, int y) {
        if (x > y) {
            return calculatePoints(s, 'a', 'b', x, y);
        } else {
            return calculatePoints(s, 'b', 'a', y, x);
        }
    }

    private static int calculatePoints(String s, char firstChar, char secondChar, int firstPoints, int secondPoints) {
        int points = 0;
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            sb.append(c);
            int sbLength = sb.length();

            if (sbLength >= 2 && sb.charAt(sbLength - 2) == firstChar && sb.charAt(sbLength - 1) == secondChar) {
                sb.delete(sbLength - 2, sbLength);
                points += firstPoints;
            }
        }

        String remaining = sb.toString();
        sb = new StringBuilder();

        len = remaining.length();
        for (int i = 0; i < len; i++) {
            char c = remaining.charAt(i);
            sb.append(c);
            int sbLength = sb.length();

            if (sbLength >= 2 && sb.charAt(sbLength - 2) == secondChar && sb.charAt(sbLength - 1) == firstChar) {
                sb.delete(sbLength - 2, sbLength);
                points += secondPoints;
            }
        }

        return points;
    }

    public static void main(String[] args) {
        String s1 = "cdbcbbaaabab";
        int x1 = 4;
        int y1 = 5;
        System.out.println(maximumGain(s1, x1, y1)); // Output: 19

        String s2 = "aabbaaxybbaabb";
        int x2 = 5;
        int y2 = 4;
        System.out.println(maximumGain(s2, x2, y2)); // Output: 20
    }
}
