package Greedy;

import java.util.Arrays;

public class AssignCookies {
    public static void main(String[] args) {
        int[] child = {1,2,1,4,6};
        int[] cookie = {1,3,2,5,3};
        int res = greedyCookie(child,cookie);
        System.out.println(res);
    }

    private static int greedyCookie(int[] child, int[] cookie) {
        Arrays.sort(child);
        Arrays.sort(cookie);
        int res = 0;
        for (int i = 0, j = 0; i <child.length && j < cookie.length; j++) {
            if (cookie[j] >= child[i]) {
                i++;
                res++;
            }
        }
        return res;
    }
}
