class Solution {
    public int makeStringSorted(String s) {
        final int mod = 1000000007;
        int n=s.length();
        long answer=0;
        int[] freq = new int[26];
        long[] factorial = new long[n+1];
        factorial[0]=1;
        for(int i=1;i<=n;i++){
            factorial[i] = factorial[i-1]*i%mod;
        }
        for(int i=n-1;i>=0;i--){
            int current = s.charAt(i)-'a';
            int smaller=0;
            for(int c=0;c<current;c++){
                smaller+=freq[c];
            }
            if(smaller>0){
                long ways = factorial[n-i-1];
                for(int c=0;c<26;c++){
                    int count=freq[c];
                    if(c==current){
                        count++;
                    }
                    ways=ways*modInverse(factorial[count], mod)%mod;
                }
                answer = (answer+ways*smaller)%mod;
            }
            freq[current]++;
        }
        return (int) answer;
    }
    private long modInverse(long x, int mod){
        return power(x, mod-2, mod);
    }
    private long power(long x, long n, int mod){
        long result=1;
        while(n>0){
            if((n&1)==1){
                result=result*x%mod;
            }
            x = x*x%mod;
            n>>=1;
        }
        return result;
    }
}