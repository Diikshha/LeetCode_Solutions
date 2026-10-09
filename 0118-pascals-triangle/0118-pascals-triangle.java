class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int row=0;row<numRows;row++){
            List<Integer> temp=new ArrayList<>();
            int value=1;
            for(int col=0;col<=row;col++){
                temp.add(value);
                value = value * (row-col)/(col+1);
            }
            ans.add(temp);
        }
        return ans;
    }
}