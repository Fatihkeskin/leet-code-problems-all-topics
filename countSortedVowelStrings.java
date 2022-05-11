class Solution {
    public int countVowelStrings(int n) {
		int result = 0;
        int dp[] = new int[]{1,1,1,1,1};
        
        for (int i = 2; i<=n; i++) {
            for(int j=3; j>=0; j--) {
                dp[j] += dp[j+1];
			}
        }
		
        for (int i=0;i<5;++i) {
			result += dp[i];
		}
        return result;
    }
}