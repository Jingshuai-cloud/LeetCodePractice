package Recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        int max = 2 * n;
        List<String> result = new ArrayList<>();
        result = backTrackGenerate2(n,0, 0,"");
        //System.out.println(result);
    }
    private static List<String> result = new ArrayList<>();

    private static List<String> backTrackGenerate2(int n, int left, int right, String parentheses) {
        if (parentheses.length() == n * 2) {
            System.out.println(parentheses);
            result.add(parentheses);
            return result;
        }

        if (left < n)
            backTrackGenerate2(n, left + 1, right, parentheses + "(");

        if (right < left)
            backTrackGenerate2(n, left, right + 1, parentheses + ")");

        return result;

    }

    //Setp 1
    private static List<String> backTrackGenerate(int level, int max, String parentheses) {
        if (level >= max) {
            System.out.println(parentheses);
            result.add(parentheses);
            return result;
        }

        backTrackGenerate(level + 1, max, parentheses + "(");
        backTrackGenerate(level + 1, max, parentheses + ")");

        return result;

    }

    //Step 2

}
