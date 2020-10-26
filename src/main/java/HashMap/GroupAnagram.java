package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramHashMapSort(strs));
        System.out.println(        groupAnagramHashMapIndex(strs));
    }

    //O(NK)
    //O(NK)
    private static ArrayList<List<String>> groupAnagramHashMapIndex(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] counter = new char[26];
            for (char c : s.toCharArray())
                counter[c - 'a']++;
            String keyStr = String.valueOf(counter);
            if (!hashMap.containsKey(keyStr))
                hashMap.put(keyStr, new ArrayList<String>());
            hashMap.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(hashMap.values());
    }

    // O(NKLogK) N for out loop. KlogK for sort
    //O(NK)
    private static ArrayList<List<String>> groupAnagramHashMapSort(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<String, List<String>>();
        for (String s : strs) {
            char[] s1 = s.toCharArray();
            Arrays.sort(s1);
            String keyStr = String.valueOf(s1);
            if (!hashMap.containsKey(keyStr))
                hashMap.put(keyStr, new ArrayList<String>());
            hashMap.get(keyStr).add(s);
        }
        return new ArrayList<List<String>>(hashMap.values());
    }
}
