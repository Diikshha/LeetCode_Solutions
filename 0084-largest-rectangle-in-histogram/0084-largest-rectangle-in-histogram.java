class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        int n=heights.length;
        for(int i=0;i<=n;i++){
            int currHeight;
            if(i==n){
                currHeight=0;
            }
            else{
                currHeight=heights[i];
            }
            while(!st.isEmpty() && heights[st.peek()]>=currHeight){
                int height = heights[st.pop()];
                int right=i;
                int left;
                if(st.isEmpty()){
                    left=-1;
                }
                else{
                    left=st.peek();
                }
                int width=right-left-1;
                int area=width*height;
                maxArea = Math.max(maxArea, area);
            }
            st.push(i);
        }
        return maxArea;
    }
}