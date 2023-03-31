class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];
        
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        System.out.println(graph.size());
        
        for(int i = 0; i < relations.length; i++) {
            int from = relations[i][0];
            int to = relations[i][1];
            
            //1 based index
            graph.get(from-1).add(to-1);
            indegree[to-1]++;
        }
        
        boolean flag = false;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
                flag = true;
            }
        }
        if(flag == false) {
            return -1;
        }
        queue.add(-1);
        
        int count = 0; //for number of sems;
        int totNodes = 0;
        
        while(queue.isEmpty() == false) {
            int node = queue.remove();
            System.out.println(node);
            if(node == -1) {
                //end of semester
                count++;
                if(queue.isEmpty()) {
                    break;
                }
                node = queue.remove();
                queue.add(-1);
            }
            totNodes++;
            
            List<Integer> nodes = graph.get(node);
            for(Integer var : nodes) {
                indegree[var]--;
                if(indegree[var] == 0) {
                    queue.add(var);
                }
            }
            
        }
        if(totNodes != n) {
            return -1;
        }
        return count;
    }
}