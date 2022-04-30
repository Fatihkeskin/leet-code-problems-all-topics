package com.company;

public class Main {

    public static void main(String[] args) {
        int[] points = {2,3,1,1,4};
        System.out.println(canJump(points));
        System.out.println();
    }

    public static boolean canJump(int[] nums) {
        return canJumpHelper(nums, 0);
    }

    public static boolean canJumpHelper(int[] nums, int currentIndex) {
        if (currentIndex == nums.length -1)
            return true;

        if (currentIndex > nums.length -1)
            return false;

        for (int i = 0; i<nums[currentIndex]; i++) {
            if (canJumpHelper(nums, currentIndex + nums[currentIndex]-i))
                return true;
        }
        return false ;
    }

}