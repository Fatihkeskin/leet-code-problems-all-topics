class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> substring = new HashMap<>();
        int lengthOfSubstring = 0;
        for (int i = 0; i < arr.length; i++) {
            if (substring.containsKey(arr[i])) {
                int shift = substring.get(arr[i]) + 1;
                Set<Map.Entry<Character, Integer>> setOfEntries = substring.entrySet();
                Iterator<Map.Entry<Character, Integer>> iterator 
                            = setOfEntries.iterator();
                while (iterator.hasNext()) { 
                    Map.Entry<Character, Integer> entry = iterator.next(); 
                    int value = entry.getValue(); 
                    if (value < shift) 
                        iterator.remove();
                    
                }
            }
            substring.put(arr[i], i);
            

lengthOfSubstring = substring.size() > lengthOfSubstring ? substring.size() : lengthOfSubstring;
        }
        
        return lengthOfSubstring;
    }
}