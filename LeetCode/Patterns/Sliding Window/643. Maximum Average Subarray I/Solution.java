class Solution {
    public double findMaxAverage(int[] arr, int k) {
        
        int sum = 0;

        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }

        int max = sum;

        for(int i = k; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i-k];
            max = Math.max(max, sum);
        }

        double c = (double) max / k;

        return c;
    }
}