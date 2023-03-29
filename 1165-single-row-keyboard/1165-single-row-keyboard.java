class Solution {
    public int calculateTime(String keyboard, String word) {
        Map<Character, Integer> hash = new HashMap<>();
        for(int i = 0; i < keyboard.length(); i++) {
            hash.put(keyboard.charAt(i), i);
        }
        
        int time = 0;
        int prev = 0;
        for(int i = 0; i < word.length(); i++) {
           time += Math.abs(hash.get(word.charAt(i)) - prev);
           prev = hash.get(word.charAt(i)); 
        }
        return time;
        
    }
}