class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            int[][] ret = new int[1][2];
            ret[0] = newInterval;
            return ret;
        }

        List<int[]> list = new ArrayList<>();
        int[] combined = new int[2];
        combined[0] = newInterval[0];
        combined[1] = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
                if(i + 1 < intervals.length && intervals[i][1] < newInterval[0] && intervals[i+1][0] > newInterval[1]){
                    list.add(newInterval);
                }
            } else if (intervals[i][0] > newInterval[1]){
                list.add(intervals[i]);
            } else {
                if (intervals[i][0] < combined[0]) combined[0] = intervals[i][0];
                if (intervals[i][1] > combined[1]) combined[1] = intervals[i][1];
                if (i + 1 < intervals.length && intervals[i+1][0] > combined[1]) {
                    list.add(combined);
                }
                if (i + 1 >= intervals.length) {
                    list.add(combined);
                }
            }
        }
        if (newInterval[1] < intervals[0][0]) {
            list.add(0,newInterval);
        }
        if (newInterval[0] > intervals[intervals.length - 1][1]){
            list.add(newInterval);
        }
        return list.toArray(new int[list.size()][2]);
    }
}