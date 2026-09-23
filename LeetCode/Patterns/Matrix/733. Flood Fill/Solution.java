class Solution {
    void dfs(int[][] image , int row , int col , int color , int iniColor , int[][] ans , int[] delrow , int[] delcol){
        ans[row][col] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i =0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            if(nrow >= 0 && nrow <n && ncol >= 0 && ncol <m && image[nrow][ncol] == iniColor && ans[nrow][ncol] != color){
                dfs(image , nrow , ncol , color , iniColor , ans , delrow , delcol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc];
        int[][] ans = image;
        int delrow[] = {-1,0,+1,0};
        int delcol[] = {0 , +1, 0,-1};
        dfs(image , sr , sc , color , iniColor , ans , delrow , delcol);
        return ans;
    }
}