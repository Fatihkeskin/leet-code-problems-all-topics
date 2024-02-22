package com.company;

import java.util.ArrayList;
import java.util.List;

class Main {

    private static boolean result = false;
    private static String max;

    public static void  main(String[] args){
        String s = "cars";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("car");
        wordDict.add("ca");
        wordDict.add("rs");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        max = s;
        return extracted(s, wordDict);
    }


    private static boolean extracted(String s, List<String> wordDict) {
        if (s.trim().equals(""))
            result = true;

        for (int i = 0; i < wordDict.size(); i++) {
            if (s.contains(wordDict.get(i))) {
                s = s.replace(wordDict.get(i), " ");
                wordDict.remove(wordDict.get(i));
                extracted(s, wordDict);
                s = max;
            }
        }
        return result;
    }

}
