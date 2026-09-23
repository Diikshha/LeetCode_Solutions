class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<num.length();i++){
            char current = num.charAt(i);
            while(k>0 && sb.length()>0 && sb.charAt(sb.length()-1)>current){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(current);
        }
        while(k>0){
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        int start=0;
        while(start<sb.length() && sb.charAt(start)=='0'){
            start++;
        }
        String result = sb.substring(start);
        if(result.length()==0){
            return "0";
        }
        return result;
    }
}