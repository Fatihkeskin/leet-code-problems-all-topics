package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }

    public static String longestPalindrome(String s) {
        if (s.length() < 2)
            return s;

        String resultString = "";
        int longestNumber = 0;
        char[] inputToCharArray = s.toCharArray();
        Map<Character, ArrayList<Integer>> dict = new HashMap<>();
        for (int k = 0; k < inputToCharArray.length; k++) {
            char c = inputToCharArray[k];
            if (dict.containsKey(c)) {
                String temp = findPalindrome(s, dict.get(s.charAt(k)), k);
                resultString = (temp.length() > resultString.length()) ? temp : resultString;
                dict.get(c).add(k);
            } else {
                ArrayList<Integer> occurences = new ArrayList<>();
                occurences.add(k);
                dict.put(c, occurences);
            }
        }
        if (resultString =="")
            return s.substring(0,1);
        return resultString;
    }

    private static String findPalindrome(String s, ArrayList<Integer> currentArrayList, int cur){
        for (int index : currentArrayList) {
            if(isPalindrome(s.substring(index,cur+1)))
                return s.substring(index,cur+1);
        }
        return "";
    }

    private static boolean isPalindrome(String word) {
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length/2; i++) {
            if (arr[i] != arr[arr.length-i-1])
                return false;
        }
        return true;
    }
}
