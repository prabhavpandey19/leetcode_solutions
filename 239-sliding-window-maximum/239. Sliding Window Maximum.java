class Solution {
     public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i=0;i<k;i++) {
            while (!dq.isEmpty() && nums[i] > dq.peekLast()) {
                dq.removeLast();
            }
            dq.addLast(nums[i]);
        }
        res[0] = dq.peekFirst();
        int j = 1;
        for (int i=k;i<nums.length;i++) {
            if (!dq.isEmpty() && dq.peekFirst() == nums[i-k]) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[i] > dq.peekLast()) {
                dq.removeLast();
            }
            dq.addLast(nums[i]);
            res[j] = dq.peekFirst();
            j++;
        }
        return res;
    }
}

// class Solution {
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n=nums.length;
//         Deque<Integer> dq=new ArrayDeque<>();
//         int ans[]=new int[n-k+1];
//         int j=0;
//         int i=0;
//         for(;i<k;i++){
//             while(dq.size()>0&&dq.getLast()<nums[i])dq.pollLast();
//             dq.addLast(nums[i]);
//         }
//         ans[j++]=dq.peekFirst();

//         for(;i<n;i++){
//             if(dq.size()>0&&dq.getFirst()==nums[i-k])dq.pollFirst();
//             while(dq.size()>0&&dq.getLast()<nums[i])dq.pollLast();
//             dq.addLast(nums[i]);
//             ans[j++]=dq.peekFirst();
//         }
//         return ans;
//     }
// }