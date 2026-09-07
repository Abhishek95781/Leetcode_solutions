class Solution {
    public double findMaxAverage(int[] arr, int k) {
         int sum = 0;

        // First window
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        // Slide the window
        for(int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i-k];
            max = Math.max(max, sum);

        }
        double c = (double) max / k;

        return c;
    }
}