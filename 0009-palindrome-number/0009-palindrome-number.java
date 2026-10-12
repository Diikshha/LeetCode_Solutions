class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int reverse=0;
        int temp=x;
        while(temp!=0){
            int digit = temp%10;
            if(reverse > Integer.MAX_VALUE || reverse< Integer.MIN_VALUE){
                return false;
            }
            reverse = reverse*10+digit;
            temp=temp/10;
        }
        if(reverse==x){
            return true;
        }
        else{
            return false;
        }
    }
}