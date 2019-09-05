class Solution {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int leftmax = 0;
        int rightmax = 0;
        int start = 0;
        int end = height.length - 1;
        int ret = 0;
        while (start <= end) {
            leftmax = Math.max(height[start],leftmax);
            rightmax = Math.max(height[end],rightmax);
            if (leftmax < rightmax) {
                ret += leftmax-height[start];
                start++;
            } else {
                ret += rightmax-height[end];
                end--;
            }
        }
        return ret;
    }
}