class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int marea = 0;
        for (int i=0;i<heights.length;i++) {
            int index = i;
            while (!stack.isEmpty() && stack.peek()[0] > heights[i]) {
                int[] a = stack.pop();
                marea = Math.max(a[0]*(i-a[1]),marea);
                index = a[1];
            }
            stack.push(new int[] {heights[i],index});
        }

        for (int[] a:stack) {
            marea  = Math.max(a[0]*(heights.length-a[1]),marea);
        }
        return marea;
    }
}