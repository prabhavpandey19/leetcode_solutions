class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] x: intervals) {
            if (newInterval == null || x[1] < newInterval[0]) {
                res.add(x);
            } else if (x[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(x);
                newInterval = null;
            } else {
                newInterval[0] = Math.min(x[0],newInterval[0]);
                newInterval[1] = Math.max(x[1],newInterval[1]);
            }
        }
        if (newInterval != null) res.add(newInterval);
        return res.toArray(new int[res.size()][]);
    }
}