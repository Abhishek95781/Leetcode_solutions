class Pair {
    int first ; 
    int second ;
    Pair(int first , int second){
        this.first = first ;
        this.second = second;
    }
}
class Solution {

    public void bfs(int row , int col , char[][] board , int[][] vis , int count){
        int n = board.length;
        int m = board[0].length;
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        int[] delrow = {-1 , 0 , +1 , 0};
        int[] delcol = {0 , +1 , 0 , -1};
        while(!q.isEmpty()){
            int ro = q.peek().first;
            int co = q.peek().second;
            q.poll();

            for(int i =0;i<4;i++){
                int nr = ro + delrow[i];
                int nc = co + delcol[i];
                if(nr >=0 && nr < n && nc >=0 && nc<m && board[nr][nc] == 'X' && vis[nr][nc] == 0){
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr , nc));
                }
            }
        }
    }
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int vis[][] = new int[n][m];
        int count = 0;
        for(int i =0;i<n;i++){
            for(int j= 0;j<m;j++){
                if(i == 0 || j ==0 || i < n-1 || j < m-1 ){
                    if(board[i][j] == 'X' &&  vis[i][j] == 0){
                        count ++;
                        bfs(i , j , board , vis, count);
                    }
                }
            }
        }

        return count;
    }
}