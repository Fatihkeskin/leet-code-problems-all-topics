class Solution {
    public int romanToInt(String s) {
        int index = 0;
        int result = 0;
        HashMap<Character, Integer> romanNumbers = new HashMap<>();
        romanNumbers.put('I',1);
        romanNumbers.put('V',5);
        romanNumbers.put('X',10);
        romanNumbers.put('L',50);
        romanNumbers.put('C',100);
        romanNumbers.put('D',500);
        romanNumbers.put('M',1000);

        char[] ch = s.toCharArray();
        while(index < s.length()) {
            char currentSymbol = ch[index];
            if (index + 1 == s.length()) {
                result += romanNumbers.get(currentSymbol);
                break;
            }

            char nextSymbol = ch[index+1];
            if(romanNumbers.get(currentSymbol) >= romanNumbers.get(nextSymbol)) {
                result += romanNumbers.get(currentSymbol);
            } else {
                result += romanNumbers.get(nextSymbol) - romanNumbers.get(currentSymbol) ;
                index++;
            }
            index++;
        }
        return result;
    }
}