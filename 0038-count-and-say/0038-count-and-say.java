class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i=2;i<=n;i++){
            StringBuilder sb = new StringBuilder();
            int j=0;
            while(j<result.length()){
                int count=0;
                char ch = result.charAt(j);
                while(j<result.length() && result.charAt(j)==ch){
                    count++;
                    j++;
                }
                sb.append(count);
                sb.append(ch);
            }
            result = sb.toString();
        }
        return result;
    }
}