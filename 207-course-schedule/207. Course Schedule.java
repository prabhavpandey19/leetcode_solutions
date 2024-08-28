class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> pre = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            pre.put(i,new ArrayList<>());
        }
        for (int[] a: prerequisites) {
            if (pre.containsKey(a[0])) {
                pre.get(a[0]).add(a[1]);
            } else {
                List<Integer> x = new ArrayList<>();
                x.add(a[1]);
                pre.put(a[0],x);
            }
        }
        Set<Integer> visited = new HashSet<>();

        boolean result = true;
        for (int i=0;i<numCourses;i++) {
            result = result && dfs1(i,pre,visited);
        }
        return result;
    }

    private boolean dfs1(int i,Map<Integer,List<Integer>> pre,Set<Integer> visited) {
        if (visited.contains(i)) {
            return false;
        }
        if (pre.get(i).isEmpty()) {
            return true;
        }
        visited.add(i);
        for (int x: pre.get(i)) {
            if(!dfs1(x,pre,visited)) {
                return false;
            }
        }
        visited.remove(i);
        pre.get(i).clear();
        return true;
    }

}