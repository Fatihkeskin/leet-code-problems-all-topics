package com.company;

public class Main {

    public static void main(String[] args) {
	    //int[] nums1 = {4,7,10,20};
        //int[] nums2 = {1,3,14,43,78};
        // 1 3 4 7 10 14 20 43 78

        //int[] nums1 = {1,3};
        //int[] nums2 = {2};
        // 1 2 3

        int[] nums1 = {};
        int[] nums2 = {2, 57, 120, 467, 476, 489, 999};

        System.out.println("Median: " + findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int iter1 = 0;
        int iter2 = 0;
        int iterMergedArr = 0;
        int[] mergedArr = new int[size1 + size2];

        if (size1 == 0) {
            return nums2.length % 2 == 1 ? nums2[nums2.length/2] : (nums2[nums2.length/2] + nums2[nums2.length/2 - 1]) / 2.0;
        }

        if (size2 == 0) {
            return nums1.length % 2 == 1 ? nums1[nums1.length/2] : (nums1[nums1.length/2] + nums1[nums1.length/2 - 1]) / 2.0;
        }
        while (iterMergedArr < mergedArr.length) {
            if ( nums1[iter1] >= nums2[iter2]) {
                mergedArr[iterMergedArr] = nums2[iter2];
                if (iter2 + 1 != nums2.length)
                    iter2++;
                else
                    nums2[iter2] = Integer.MAX_VALUE;
            } else {
                mergedArr[iterMergedArr] = nums1[iter1];
                if (iter1 + 1 != nums1.length)
                    iter1++;
                else
                    nums1[iter1] = Integer.MAX_VALUE;
            }
            iterMergedArr++;
        }
        return mergedArr.length % 2 == 1 ? mergedArr[mergedArr.length/2] : (mergedArr[mergedArr.length/2] + mergedArr[mergedArr.length/2 - 1]) / 2.0;
    }
}
