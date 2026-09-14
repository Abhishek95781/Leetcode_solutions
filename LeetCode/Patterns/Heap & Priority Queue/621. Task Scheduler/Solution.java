class Pair {
    char task;
    int freq;

    Pair(char task, int freq) {
        this.task = task;
        this.freq = freq;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> b.freq - a.freq
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new Pair((char)('A' + i), freq[i]));
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {

            int cycle = n + 1;
            ArrayList<Pair> temp = new ArrayList<>();

            while (cycle > 0 && !pq.isEmpty()) {

                Pair curr = pq.poll();

                curr.freq--;

                if (curr.freq > 0) {
                    temp.add(curr);
                }

                time++;
                cycle--;
            }

            for (Pair p : temp) {
                pq.add(p);
            }

            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}