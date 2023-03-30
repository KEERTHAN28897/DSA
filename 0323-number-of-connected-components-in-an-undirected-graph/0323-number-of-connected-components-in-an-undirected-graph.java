class Solution {
    
    public void dfs(List<List<Integer>> graph, int node, boolean[] visited) {
        List<Integer> nodeList = graph.get(node);
        
        
        if(visited[node] == true) {
            
            return;
        }
        visited[node] = true;
        for(Integer currNodes : nodeList) {
            dfs(graph, currNodes, visited);
        }
        
        return;
    }
    
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            set.add(from); set.add(to);
        }
        
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        //traverse graph now
        for(int i = 0; i < n; i++) {
            if(visited[i] == false) {
                count++;
                dfs(graph, i, visited);
            
                
            }
        }
        return count;    
    }
}