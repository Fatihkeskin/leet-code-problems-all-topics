package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
    }

    public static boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');


        List<Character> charArr = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                charArr.add(ch);
            } else {
                if (charArr.size() > 0) {
                    if (charArr.get(charArr.size()-1) != map.get(ch))
                        return false;
                    else
                        charArr.remove(charArr.size()-1);
                } else {
                    return false;
                }
            }
        }

        return charArr.size() == 0 ? true : false ;
    }
}
