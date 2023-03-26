class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        int[] ransom = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            ransom[magazine.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < ransomNote.length(); i++) {
            if(ransom[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            } else {
               ransom[ransomNote.charAt(i) - 'a']--; 
            }
        }
        return true;
        
    }
}