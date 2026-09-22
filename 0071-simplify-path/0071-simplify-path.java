class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Stack<String> st = new Stack<>();
        for(int i=0;i<parts.length;i++){
            if(parts[i].equals("") || parts[i].equals(".")){
                continue;
            }
            else if(parts[i].equals("..")){
                if(st.size()>0){
                    st.pop();
                }
                else{
                    continue;
                }
            }
            else{
                st.push(parts[i]);
            }
        }
        Stack<String> helper = new Stack<>();
        StringBuilder ans = new StringBuilder();
        if(st.size()==0){
            ans.append("/");
            return ans.toString();
        }
        while(st.size()!=0){
            helper.push(st.pop());
        }
        while(helper.size()!=0){
            ans.append("/").append(helper.pop());
        }
        return ans.toString();
    }
}