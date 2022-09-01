class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> charToCount = new HashMap<>();
        for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int count = charToCount.getOrDefault(ch, 0) + 1;
            charToCount.put(ch, count);
        }
        
        int tot = 0;
        boolean flag = false;
        for(Integer count : charToCount.values()) {
            if(count % 2 != 0) {
                flag = true;
            }
            tot = tot + (count / 2);
            
        }
        tot = tot*2;
        if(flag) {
            tot++;
        }
        
        return (tot);
    }
}