package HashMap;

import java.util.Arrays;

public class IsAnagram {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagramBruteForce(s, t);
        boolean result2 = isAnagramHashTable(s, t);
        System.out.println(result2);
    }

    //time O(n)/Space O(1)
    private static boolean isAnagramHashTable(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count: counter) {
            if (count != 0)
                return false;
        }
        return true;
    }

    //time complexity O(NlogN) ,space O(n)
    private static boolean isAnagramBruteForce(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        return Arrays.equals(s1, t1);
    }
}
