class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long a = power(5, even);
        long b = power(4, odd);
        return (int) ((a * b) % MOD);
    }
    private long power(long x, long n) {
        long result = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                result = (result * x) % MOD;
            }
            x = (x * x) % MOD;
            n = n / 2;
        }

        return result;
    }
}