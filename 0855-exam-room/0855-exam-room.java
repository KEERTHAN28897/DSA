class ExamRoom {
    TreeSet<Integer> st;
    int n;

    public ExamRoom(int n) {
        st = new TreeSet<>();
        this.n = n;
    }
    
    public int seat() {
        if(st.isEmpty()){
            st.add(0);
            return 0;
        }
        int max = st.first();
        int idx = 0;
        int prev = st.first();
        boolean flag = true;
        for(var e:st){
            if(flag){
                flag = false;
                continue;
            }
            int d = (e - prev) / 2;
            if(d > max){
                idx = prev + d;
                max = d;
            }
            prev = e;
        }
        if(n - 1 - prev > max){
            idx = n - 1;
        }

        st.add(idx);
        return idx;
    }
    
    public void leave(int p) {
        st.remove(p);
    }
}