class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1 || numRows>=s.length()){
            return s;
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++){
            rows[i] = new StringBuilder();
        }
        int currentRows=0;
        int direction=1;
        for(int i=0;i<s.length();i++){
            rows[currentRows].append(s.charAt(i));
            if(currentRows==0){
                direction=1;
            }
            else if(currentRows==numRows-1){
                direction=-1;
            }
            currentRows+=direction;
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<numRows;i++){
            result.append(rows[i]);
        }
        return result.toString();
    }
}