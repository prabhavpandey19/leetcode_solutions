class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> pre = new HashMap<>();
        for (int[] a: prerequisites) {
            pre.putIfAbsent(a[0], new ArrayList<>());
            pre.get(a[0]).add(a[1]);
        }
        Set<Integer> visted = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        List<Integer> res = new ArrayList<>();
        for (int i=0;i<numCourses;i++) {
            if (!dfs(pre,i,visted,res,cycle)) {
                return new int[]{};
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(Map<Integer, List<Integer>> pre, int i, Set<Integer> visted, List<Integer> res, Set<Integer> cycle) {
        if (cycle.contains(i)) {
            return false;
        }
        if (visted.contains(i)) {
            return true;
        }
        if (pre.get(i) != null) {
            cycle.add(i);
            for (int x:pre.get(i)) {
                if (!dfs(pre,x,visted,res,cycle)) {
                    return false;
                }
            }
            cycle.remove(i);
        }
        visted.add(i);
        res.add(i);
        return true;
    }

}