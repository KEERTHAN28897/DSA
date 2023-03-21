class Solution {
   //largest to smallest add, smallest to largest sub
    
    public int getValue(char ch) {
        switch(ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
    
    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int val = 0;
        for(int i = 0; i < ch.length-1; i++) {
            int currVal = getValue(ch[i]);
            int nextVal = getValue(ch[i+1]);
            if(currVal >= nextVal) {
                val += currVal;
            } else {
                val -= currVal;
            }
        }
        val = val +  getValue(ch[ch.length-1]);
        
        return val;
    }
}