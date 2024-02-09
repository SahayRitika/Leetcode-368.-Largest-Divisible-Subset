class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];
        int maxi=1,last_idx=0;

        Arrays.fill(dp,1);
        Arrays.fill(hash,1);
        for(int i=0;i<n;i++){
            hash[i] = i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i] = dp[j]+1;
                    hash[i] = j;
                }
                if(dp[i]>maxi){
                    maxi = dp[i];
                    last_idx = i;
                }
            }
        }

        res.add(nums[last_idx]);
        while(hash[last_idx]!=last_idx){
            last_idx = hash[last_idx];
            res.add(nums[last_idx]);
        }

        Collections.reverse(res);
        return res;

    }
}
