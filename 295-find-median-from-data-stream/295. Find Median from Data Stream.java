class MedianFinder {

    PriorityQueue<Integer> fHalf;
    PriorityQueue<Integer> sHalf;


    public MedianFinder() {
        fHalf = new PriorityQueue<>(Comparator.reverseOrder());
        sHalf = new PriorityQueue<>();
    }

    public void addNum(int num) {
        fHalf.add(num);
        balanceHeap();
    }

    private void balanceHeap() {
        while (!fHalf.isEmpty() && !sHalf.isEmpty() && fHalf.peek() > sHalf.peek()) {
            sHalf.add(fHalf.poll());
        }
        while (fHalf.size() - sHalf.size() > 1) {
            sHalf.add(fHalf.poll());
        }
        while (sHalf.size() - fHalf.size() > 1) {
            fHalf.add(sHalf.poll());
        }
    }

    public double findMedian() {
        if (fHalf.size() == sHalf.size()) {
            return (double) (fHalf.peek() + sHalf.peek()) / 2;
        } else if (fHalf.size() > sHalf.size()) {
            return (double) fHalf.peek();
        } else {
            return (double) sHalf.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */