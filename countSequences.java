// gives MLE, use HashMap based indexing with a key = idx#num#den and store no of ways you can go, wasnt very difficult, just only problem was to identify the map based approach

class Solution {

    static int count;

    public static int solve(int[] nums, long k, long num, long den, int idx,int[][][] dp) {
        if (idx == nums.length) {
            if (den != 0 && num == k * den) {
                return 1;
            }
            return 0;
        }
        if (dp[idx][(int)num][(int)den] != -1) return dp[idx][(int)num][(int)den] ;

        int m = solve(nums, k, num * nums[idx], den, idx + 1, dp);
        int d = solve(nums, k, num, den * nums[idx], idx + 1,dp);
        int l = solve(nums, k, num, den, idx + 1,dp);
        // int result = (m == 1 || d == 1 || l == 1 ? 1 : 0 );
        return dp[idx][(int)num][(int)den]  = m + d + l;
    }

    public int countSequences(int[] nums, long k) {
         int maxVal = 1;
        for (int i=0;i<nums.length;i++){
            maxVal *= nums[i];
        }
        int[][][] dp = new int[nums.length][maxVal][maxVal];
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[i].length;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        count = 0;
        return solve(nums, k, 1L, 1L, 0, dp);
        // if (k == 1) count--;

        // return count;
    }
}
