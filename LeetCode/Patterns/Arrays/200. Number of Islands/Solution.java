class Pair{
    int first ; 
    int second ;
    Pair(int first , int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {

    public void bfs(int row, int col , char[][] grid , int[][] vis){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        int[] delrow = {-1, 0 , +1 , 0};
        int[] delcol = {0, +1, 0 , -1};

        while(!q.isEmpty()){
            int ro = q.peek().first;
            int co = q.peek().second;
            q.poll();

            for(int i =0;i<4;i++){
                int nr = delrow[i] + ro;
                int nc = delcol[i] + co;

                if(nr>=0 && nr<n && nc>=0 && nc<m && vis[nr][nc]==0 && grid[nr][nc]=='1'){
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr , nc));
                }
            }
            
        }
        
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];
        int count = 0;
        for(int i = 0 ;i<n;i++){
            for(int j =0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    count ++;
                    bfs( i , j ,grid , vis);
                }
            }
        }
        return count;
    }
}