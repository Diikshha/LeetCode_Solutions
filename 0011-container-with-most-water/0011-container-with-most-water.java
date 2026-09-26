class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxWater =0;
        int left=0;
        int right=n-1;
        while(left<right){
            int w= right-left;
            int h=Math.min(height[left], height[right]);
            int area = w*h;
            maxWater = Math.max(area,maxWater);
            if(height[left]<height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxWater;
    }
}