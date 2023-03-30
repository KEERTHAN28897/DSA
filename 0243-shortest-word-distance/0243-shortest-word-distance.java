class Solution {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int dis1 = Integer.MAX_VALUE; int dis2 = wordsDict.length;
        int i = 0;
        int ans = wordsDict.length;
        for(String word : wordsDict) {
            if(word.equals(word1)) {
                dis1 = i;
            } 
            if(word.equals(word2)) {
                dis2 = i;
            }
        System.out.println(dis1 + " " + dis2);
            
            int min = Math.abs(dis1 - dis2);
            if(ans > min) {
                ans = min;
            }
            i++;
        }
        return ans;
     }
}