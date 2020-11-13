package Greedy;

public class LemonladeChange {
    public static void main(String[] args) {
        int[] bills = {5,5,10,20, 10};
        boolean res = greedyChange(bills);
        System.out.println(res);
    }

    private static boolean greedyChange(int[] bills) {
        int five  = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            if (bill == 10) {
                five--;
                ten++;
            }
            if (bill == 20) {
                if (ten > 0) {
                    ten--;
                    five--;
                }else {
                    five -= 3;
                }
            }
            if (five < 0) return false;
        }
        return  true;
    }
}
