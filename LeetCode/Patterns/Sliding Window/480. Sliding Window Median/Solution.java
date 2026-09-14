class Solution {
    TreeMap<Integer, Integer> small = new TreeMap<>();
    TreeMap<Integer, Integer> large = new TreeMap<>();

    int smallSize = 0;
    int largeSize = 0;

    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] ans = new double[n - k + 1];

        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }

        ans[0] = getMedian(k);

        for (int i = k; i < n; i++) {
            remove(nums[i - k]);
            add(nums[i]);

            ans[i - k + 1] = getMedian(k);
        }

        return ans;
    }

    void add(int x) {
        if (small.isEmpty() || x <= small.lastKey()) {
            small.put(x, small.getOrDefault(x, 0) + 1);
            smallSize++;
        } else {
            large.put(x, large.getOrDefault(x, 0) + 1);
            largeSize++;
        }

        balance();
    }

    void remove(int x) {
        if (small.containsKey(x)) {
            removeFromMap(small, x);
            smallSize--;
        } else {
            removeFromMap(large, x);
            largeSize--;
        }

        balance();
    }

    void balance() {
        // small can have at most one extra element
        while (smallSize > largeSize + 1) {
            int x = small.lastKey();

            removeFromMap(small, x);
            smallSize--;

            large.put(x, large.getOrDefault(x, 0) + 1);
            largeSize++;
        }

        while (smallSize < largeSize) {
            int x = large.firstKey();

            removeFromMap(large, x);
            largeSize--;

            small.put(x, small.getOrDefault(x, 0) + 1);
            smallSize++;
        }
    }

    void removeFromMap(TreeMap<Integer, Integer> map, int x) {
        int count = map.get(x);

        if (count == 1)
            map.remove(x);
        else
            map.put(x, count - 1);
    }

    double getMedian(int k) {
        if (k % 2 == 1) {
            return small.lastKey();
        }

        return ((double) small.lastKey() + large.firstKey()) / 2.0;
    }
}