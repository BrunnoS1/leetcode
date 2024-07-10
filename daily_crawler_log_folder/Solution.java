import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static int minOperations(String[] logs) {
        Stack<String> stack = new Stack<String>();
        for (String log : logs) {
            if (log.equals("./"))
                continue;
            if (!log.equals("../"))
                stack.push(log);
            else if (!stack.isEmpty())
                stack.pop();
        }
        int minOperations = stack.size();
        return minOperations;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().replaceAll("[\"\\]\\[]","");
        String[] logs = line.split(",");
        System.out.println(minOperations(logs));
        sc.close();
    }
}