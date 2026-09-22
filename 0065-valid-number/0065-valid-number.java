class Solution {
    public boolean isNumber(String s) {
        int eIndex=-1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='e' || s.charAt(i)=='E'){
                eIndex=i;
                break;
            }
        }
        if(eIndex!=-1){
            if(eIndex==0 || eIndex==s.length()-1){
                return false;
            }
            String base = s.substring(0,eIndex);
            String exponent = s.substring(eIndex+1);
            if(!isInteger(base) && !isDecimal(base)){
                return false;
            }
            if(!isInteger(exponent)){
                return false;
            }
            return true;
        }
        return isInteger(s) || isDecimal(s);
    }
    private boolean isInteger(String s){
        if(s.length()==0){
            return false;
        }
        int i=0;
        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            i++;
        }
        if(i==s.length()){
            return false;
        }
        while(i<s.length()){
            char ch = s.charAt(i);
            if(ch<'0' || ch>'9'){
                return false;
            }
            i++;
        }
        return true;
    }
    private boolean isDecimal(String s){
        if(s.length()==0){
            return false;
        }
        int i=0;
        if(s.charAt(0)=='+' || s.charAt(0)=='-'){
            i++;
        } 
        boolean hasDigitBeforeDot=false;
        boolean hasDigitAfterDot=false;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            hasDigitBeforeDot=true;
            i++;
        }
        if(i>=s.length() ||  s.charAt(i)!='.'){
            return false;
        }
        i++;
        while(i<s.length() && Character.isDigit(s.charAt(i))){
            hasDigitAfterDot=true;
            i++;
        }
        if(i!=s.length()){
            return false;
        }
        return hasDigitBeforeDot || hasDigitAfterDot;
    }
}