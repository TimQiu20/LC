class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (p1,p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
        int[][] ret = new int [K][2];
        for (int i = 0; i < K; i++) {
            ret[i] = points[i];
        }
        return ret;
    }
}