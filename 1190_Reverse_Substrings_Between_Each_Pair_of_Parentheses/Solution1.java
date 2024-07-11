import java.util.ArrayList;
import java.util.Stack;

class Solution1 {
    private static String reverseParentheses(String s) {
        ArrayList<Character> arrayS = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            arrayS.add(s.charAt(i));
        }
        Stack<Integer> openP = new Stack<Integer>();
        for (char c : arrayS) {
        }
        for (int i = 0; i < arrayS.size(); i++) {
            if (arrayS.get(i) == '(') openP.push(i);
            else if (arrayS.get(i) == ')') {
                int j = openP.pop();
                int k = i-2;
                arrayS.remove(i);
                arrayS.remove(j);
                while (j < k) {
                    char aux = arrayS.get(j); 
                    arrayS.set(j, arrayS.get(k));
                    arrayS.set(k, aux);
                    j++;
                    k--;
                }
                for (char c : arrayS) {
                }
                i -= 2;
            }
        }
        s = "";
        for (int i = 0; i < arrayS.size(); i++) {
            if (arrayS.get(i) != '(' && arrayS.get(i) != ')'){
                s += arrayS.get(i);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String s = "(u(love)i)";
        System.out.println(reverseParentheses(s));
    }
}