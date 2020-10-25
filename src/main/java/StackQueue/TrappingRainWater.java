package StackQueue;

import java.util.Stack;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = trappingRainBruteForce(height);
        int result2 = trappingRainStack(height);
        System.out.println(result);
    }

    private static int trappingRainStack(int[] height) {
        int result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int current = stack.pop();
                if (stack.isEmpty())
                    break;
                int distance = i - stack.peek() - 1;
                int boundHeight = Math.min(height[i], height[stack.peek()]) - height[current];
                result += distance * boundHeight;
            }
            stack.push(i);
        }
        return result;
    }

    private static int trappingRainBruteForce(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int left = 0, right = 0;
            for (int j = i; j >= 0; j--) {
                left = Math.max(left, height[j]);
            }
            for (int k = i; k < height.length; k++) {
                right = Math.max(right, height[k]);
            }
            result += Math.min(left, right) - height[i];
        }
        return result;
    }
}
