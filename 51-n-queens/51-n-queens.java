class Solution {
    Set<Integer> diag = new HashSet<>();
    Set<Integer> anti = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    List<List<String>> res = new ArrayList<>();
    
    
    public void addBoard(char[][] state, int n) {
        List<String> board = new ArrayList<String>();
        for (int row = 0; row < n; row++) {
            String current_row = new String(state[row]);
            board.add(current_row);
        }
        res.add(board);
    }    
    
    public void backtrack(int n, int index, char board[][]) {
      /*
      for(int i = 0; i < n; i++) {
          for(int j = 0; j < n; j++) {
              System.out.print(board[i][j] + " ");
          }
          System.out.println();
      }
      System.out.println("------"); */
      if(n == index) {
           //System.out.println(board);
           addBoard(board, n);
           return;
       } 
        
       //try to place in one of column, if not then return
       
       for(int i = 0; i < n; i++) {
            if(cols.contains(i)) {
                continue;
            }    
            int d = index + i;
            int ad = index - i;
            if(diag.contains(d) || anti.contains(ad)) {
                continue;
            }
           cols.add(i); diag.add(d); anti.add(ad); 
           board[index][i] = 'Q';
           
           backtrack(n, index+1, board);
           
           cols.remove(i); diag.remove(d); anti.remove(ad);
           board[index][i] = '.';
           
       }
    }
    
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                board[i][j] = '.';
            }
        }
        backtrack(n, 0, board);
        return res;
    }
}