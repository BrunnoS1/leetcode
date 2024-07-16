class Solution1 {
    static int maximumGain(String s, int x, int y) {
        int points = 0;
        int maxPoints = x > y ? x : y;
        int minPoints = x > y ? y : x;
        String maxPattern = x > y ? "ab" : "ba";
        String minPattern = x > y ? "ba" : "ab";
        int counter = 0;

        while (counter < s.length()-1){
            int i = 0;
            while (i < s.length() - 1) {
                String foundChars = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
                if (foundChars.equals(maxPattern)) {
                    points += maxPoints;
                    s = s.substring(0, i) + s.substring(i + 2);
                    i = 0;
                } else i++;
            }

            i = 0;

            while (i < s.length() - 1) {
                String foundChars = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i + 1));
                if (foundChars.equals(minPattern)) {
                    points += minPoints;
                    s = s.substring(0, i) + s.substring(i + 2);
                    i = 0;
                } else i++;
            }

            counter++;
        }
        return points;
    }

    public static void main(String[] args) {
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));
    }
}