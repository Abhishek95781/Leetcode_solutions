// class Solution {
//     public int climbStairs(int n) {
//         if (n==0 || n ==1 ) return 1;
        
//         return climbStairs(n-1) + climbStairs(n-2);
        
//     }
// }

// class Solution {
//    public static int climbStairs(int n) {
//      int[] dp = new int[46];
//        if(n==1) return 1;
//        if(n==2) return 2;
//         if (dp[n] != 0) return dp[n];
//         dp[n] =  climbStairs(n-1) + climbStairs(n-2);
//         return dp[n];
//     }
// };

class Solution {
    int[] dp = new int[46];   // because n ≤ 45 in LeetCode

    public int climbStairs(int n) {
        // base cases (same logic you used)
        if (n == 1) return 1;
        if (n == 2) return 2;

        // if already calculated, reuse it
        if (dp[n] != 0) return dp[n];

        // same recurrence as your code
        dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
        return dp[n];
    }
}
