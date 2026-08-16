class Solution {

    public boolean check(int start, int n, int[] color, int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int front = q.remove();
            int currColor = color[front];

            for (int it : graph[front]) {
                if (color[it] == color[front]) {
                    return false;
                } else if (color[it] == -1) {
                    color[it] = 1 - currColor;
                    q.add(it);
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {          // Start BFS only if unvisited
                if (!check(i, n, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }
}