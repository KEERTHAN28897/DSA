class Vector2D {

    List<Integer> arr = new ArrayList<>();
    int curr = 0;
    public Vector2D(int[][] vec) {
        for(int i = 0; i < vec.length; i++) {
            for(int j = 0; j < vec[i].length; j++) {
                arr.add(vec[i][j]);
            }
        }
    }
    
    public int next() {
        int ans = arr.get(curr);
        curr++;
        return ans;
    }
    
    public boolean hasNext() {
        if(curr < arr.size()) {
            return true;
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */