package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String input = "\"abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\\\"#$%&'()*+,-./:;<=>?@[\\\\]^_`{|}~ ";
        System.out.println(lengthOfLongestSubstring(input));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> characterSet = new HashMap<Character, Integer>();
        int longestStreak = 0;
        int currentStreak = 0;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if (characterSet.containsKey(arr[i])) {
                i = characterSet.get(arr[i]) + 1;
                characterSet.clear();
                characterSet.put(arr[i] , i);
                currentStreak = 1;
            } else {
                characterSet.put(arr[i], i);
                currentStreak++;
                if(currentStreak > longestStreak)
                    longestStreak = currentStreak;
            }
        }
        return longestStreak;
    }
}
