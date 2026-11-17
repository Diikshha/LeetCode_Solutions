class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        int start = Search(nums, target, true);
        int end = Search(nums, target, false);
        ans[0]=start;
        ans[1]=end;
        return ans;
    }
    private int Search(int[] nums, int target, boolean findSearch){
        int left=0;
        int right= nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid= left+(right-left)/2;
            if(nums[mid]==target){
                ans=mid;
                if(findSearch){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            else if(target<nums[mid]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return ans;
    }
}