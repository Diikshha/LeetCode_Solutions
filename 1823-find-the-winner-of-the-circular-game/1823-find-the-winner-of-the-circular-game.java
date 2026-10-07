class Solution {
    public int findTheWinner(int n, int k) {
        ArrayList<Integer> people = new ArrayList<>();
        for(int i=1;i<=n;i++){
            people.add(i);
        }
        int index=0;
        while(people.size()>1){
            index = (index+k-1)%people.size();
            people.remove(index);
        }
        return people.get(0);
    }
}