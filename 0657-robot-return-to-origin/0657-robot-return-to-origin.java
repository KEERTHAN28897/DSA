class Solution {
    public void movePawn(int[] pos, char ch) {
        switch (ch) {
            case 'U':
                pos[1] = pos[1] + 1;
                return;
            case 'D':
                pos[1] = pos[1] - 1;
                return;
            case 'L':
                pos[0] = pos[0] - 1;
                return;
            case 'R':
                pos[0] = pos[0] + 1;
                return;    
        }
    }
    
    public boolean judgeCircle(String moves) {
        int[] pos = new int[2];
        for(int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            movePawn(pos, ch);
        }
        
        if (pos[0] == 0 && pos[1] == 0) {
            return true;
        }
        return false;
    }
}