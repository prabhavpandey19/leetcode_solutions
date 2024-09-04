class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        res.add(intervals[0]);
        for (int i=1;i<intervals.length;i++) {
            int cs = intervals[i][0];
            if (cs <= res.get(res.size()-1)[1]) {
                res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
            }

        }
        int[][] r = new int[res.size()][2];
        int i=0;
        for (int[] a:res) {
            r[i] = a;
            i++;
        }

        return r;
    }
}