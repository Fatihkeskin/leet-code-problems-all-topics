class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
                int minFrogs = 0;
        int currentFrogs = 0;
        Map<Character, Integer> croakMap = new HashMap<>();
        croakMap.put('c', 0);
        croakMap.put('r', 1);
        croakMap.put('o', 2);
        croakMap.put('a', 3);
        croakMap.put('k', 4);
        
        char[] arr = croakOfFrogs.toCharArray();
        int c=0, r=0, o=0, a=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'c') {
                currentFrogs++;
                c += 1;
            } else if(arr[i] == 'r') {
                if (c < 1) {
                    return -1;
                } else {
                    c -= 1;
                    r += 1;
                }
            } else if(arr[i] == 'o') {
                if (r < 1) {
                    return -1;
                } else {
                    r -= 1;
                    o += 1;
                }
            } else if(arr[i] == 'a') {
                if (o < 1) {
                    return -1;
                } else {
                    o -= 1;
                    a += 1;
                }
            } else if(arr[i] == 'k') {
                if (a < 1) {
                    return -1;
                } else {
                    a -= 1;
                }
                currentFrogs--;
            } else {
                return -1;
            }

            minFrogs = Math.max(minFrogs, currentFrogs);
        }

        return currentFrogs == 0 ? minFrogs : -1;
    }
    
    
}