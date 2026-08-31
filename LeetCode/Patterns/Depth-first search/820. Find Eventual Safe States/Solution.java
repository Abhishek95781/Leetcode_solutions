class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        int m = graph.length;
        int indegree[] = new int[m];
        for(int i =0 ; i<m ; i++){
            adjRev.add(new ArrayList<>());
        }

        for(int i =0;i<m;i++){
            for(int it : graph[i]){
                adjRev.get(it).add(i);
                indegree[i] ++;
            }
        }

        

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i = 0 ; i<m;i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safeNodes.add(node);

            for(int it : adjRev.get(node)){
                indegree[it] --;
                if(indegree[it] == 0) q.add(it);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}