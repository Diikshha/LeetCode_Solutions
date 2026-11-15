class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int reverse=0;
        int temp=x;
        while(x!=0){
            int digit = x%10;
            if(reverse>Integer.MAX_VALUE || reverse<Integer.MIN_VALUE){
                return false;
            }
            reverse=reverse*10+digit;
            x=x/10;
        }
        if(reverse==temp){
            return true;
        }
        else{
            return false;
        }
    }
}