class Solution {
    public int getValid(char ch) {
        if((int)ch >= 49 && (int)ch <= 58) {
            return (int)ch - 48;
        }
        
        if((int)ch == 46) {
            return 0;
        }
        
        return -1;
    }
    
    public boolean isValidSudoku(char[][] board) {
        Set<Integer> box = new HashSet<>();
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        
      
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
        int x= 0, y = 0;
        
        while(x < m && y < n) {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    System.out.println((i + x) + " " + (j + y));
                    int num = getValid(board[i+x][j+y]);
    
                    //System.out.print(num + ", ");
                    if(num == 0) {
                        continue;
                    }
                    
                    if(num == -1) {
                        return false;
                    }
                    if(box.contains(num) || rows.get(i+x).contains(num) || cols.get(j+y).contains(num)) {
                        return false;
                    }
                    box.add(num);
                    rows.get(i+x).add(num);
                    cols.get(j+y).add(num);
                    
                }
            }
            //System.out.println(box);
            //System.out.println(cols);
             System.out.println();
            System.out.println(x);
            x = x + 3;
             System.out.println(x);
     
     
            box.clear();
            
            
            if(x > 7) {
                x = 0;
                y = y + 3;
            }
            
        }
        
    
        
        
        
        
        return true;
    }
}