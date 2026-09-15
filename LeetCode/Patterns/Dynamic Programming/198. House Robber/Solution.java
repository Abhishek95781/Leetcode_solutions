// class Solution {
//     public int rob(int[] arr) {
//         int n = arr.length;
//         if(n==1) return arr[0];
//         int[] dp = new int[n];
//         dp[0] = arr[0];
//         dp[1] = Math.max(arr[0],arr[1]);
//         for(int i =2;i<n;i++){
//             dp[i] = Math.max(arr[i] + dp[i-2] , dp[i-1]);
//         }
//         return dp[n-1];
//     }
// }

class Solution {
    public int amount(int[] arr , int i ,int[] dp){
        if(i>= arr.length) return 0;
        if(dp[i] != -1) return dp[i];
        int take = arr[i] +amount(arr,i+2,dp);
        int skip = amount(arr,i+1,dp);
        return dp[i] = Math.max(take,skip);
    }
    public int rob(int[] arr){
        // i varies from 0 to n-1
        int[] dp = new int[arr.length];
        Arrays.fill(dp,-1);
        return amount(arr,0,dp);
    }
}