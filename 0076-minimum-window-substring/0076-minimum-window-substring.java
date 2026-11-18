class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        HashMap<Character, Integer> targetMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for(char ch:t.toCharArray()){
            targetMap.put(ch, targetMap.getOrDefault(ch,0)+1);
        }
        int req = targetMap.size();
        int formed=0;
        int left=0;
        int minLen = Integer.MAX_VALUE;
        int startIndex=0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            windowMap.put(ch, windowMap.getOrDefault(ch,0)+1);
            if(targetMap.containsKey(ch) && windowMap.get(ch).intValue()==targetMap.get(ch).intValue()){
                formed++;
            }
            while(formed==req){
                int currentLen = right-left+1;
                if(currentLen<minLen){
                    minLen = currentLen;
                    startIndex=left;
                }
                char leftChar = s.charAt(left);
                windowMap.put(leftChar, windowMap.get(leftChar)-1);
                if(targetMap.containsKey(leftChar) && windowMap.get(leftChar)<targetMap.get(leftChar)){
                    formed--;
                }
                left++;
            }
        }
        if(minLen==Integer.MAX_VALUE){
            return "";
        }
        return s.substring(startIndex, startIndex+minLen);
    }
}