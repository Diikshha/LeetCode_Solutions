class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int m=nums1.length;
        int n=nums2.length;
        int left=0;
        int right=m;
        while(left<=right){
            int cut1 = left+(right-left)/2;
            int cut2 = (m+n+1)/2 -cut1;
            int l1,l2,r1,r2;
            if(cut1==0){
                l1 = Integer.MIN_VALUE;
            }
            else{
                l1 = nums1[cut1-1];
            }
            if(cut1==m){
                r1 = Integer.MAX_VALUE;
            }
            else{
                r1 = nums1[cut1];
            }
            if(cut2==0){
                l2 = Integer.MIN_VALUE;
            }
            else{
                l2 = nums2[cut2-1];
            }
            if(cut2==n){
                r2 = Integer.MAX_VALUE;
            }
            else{
                r2 = nums2[cut2];
            }
            if(l1<=r2 && l2<=r1){
                if((m+n)%2==1){
                    return Math.max(l1,l2);
                }
                return ((double) Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(l1>r2){
                right=cut1-1;
            }
            else{
                left=cut1+1;
            }
        }
        return 0.0;
    }
}