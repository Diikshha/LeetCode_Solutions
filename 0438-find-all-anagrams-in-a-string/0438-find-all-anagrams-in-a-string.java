class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n=s.length();
        int k=p.length();
        if(k>n){
            return ans;
        }
        int[] freq = new int[26];
        for(int i=0;i<k;i++){
            freq[p.charAt(i)-'a']++;
        }
        int left=0;
        for(int right=0;right<n;right++){
            freq[s.charAt(right)-'a']--;
            if(right-left+1>k){
                freq[s.charAt(left)-'a']++;
                left++;
            }
            if(right-left+1==k){
                boolean isAnagram=true;
                for(int i=0;i<26;i++){
                    if(freq[i]!=0){
                        isAnagram=false;
                        break;
                    }
                }
                if (isAnagram) {
                    ans.add(left);
                }
            }
        }
        return ans;
    }
}
