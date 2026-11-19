class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,candidates, target, ans, new ArrayList<>());
        return ans;
    }
    private void backtrack(int index, int[] arr, int target, List<List<Integer>> ans , List<Integer> temp){
        if(index==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr[index]<=target){
            temp.add(arr[index]);
            backtrack(index, arr, target-arr[index], ans, temp);
            temp.remove(temp.size()-1);
        }
        backtrack(index+1, arr, target, ans, temp);
    }
}