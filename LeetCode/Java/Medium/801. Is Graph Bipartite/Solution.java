class Solution {
    boolean check(int start, int n, int color[], int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;
        while (!q.isEmpty()) {
            int node = q.peek();
            q.poll();

            for (int it : graph[node]) {
                if (color[it] == -1) {
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        for (int i = 0; i < n; i++)
            color[i] = -1;
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (check(i, n, color, graph) == false) {
                    return false;
                }
            }
        }
        return true;
    }
}

// class Solution {
//     public boolean dfs(int node , int col ,int[][] graph , int[] color){
//         color[node] = col;
//         for( int it : graph[node]){
//             if(color[it] == -1){
//                 if(dfs(it , 1-col , graph , color) == false) return false;;
//             }
//             else if(color[it] == col){
//                 return false;
//             }
//         }
//         return true;
//     }
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;

//         int[] color = new int[n];
//         for(int i =0;i<n;i++) color[i] = -1;
//         for(int i =0;i<n;i++){
//             if(color[i] == -1){
//                 // 0 is intializeing color 
//                 if(dfs(i , 0 , graph , color) == false) return false;
//             }
//         }
//         return true;
//     }
// }