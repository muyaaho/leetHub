import java.util.*;

class Solution {
    Integer[] sarr;
    public int[] findRightInterval(int[][] intervals) {
        int[] answer = new int[intervals.length];
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            dict.put(intervals[i][0], i);
        }

        sarr = dict.keySet().toArray(new Integer[0]);
        Arrays.sort(sarr);

        for (int i = 0; i < intervals.length; i++) {
            int idx = findIdx(intervals[i][1]);

            if (idx >= intervals.length) {
                answer[i] = -1;
                continue;
            }
            answer[i] = dict.get(sarr[idx]);
        }
        return answer;
    }

    private int findIdx(int target) {
        int left = 0, right = sarr.length;

        while (left < right) {
            int mid = (left + right) / 2;

            if (sarr[mid] < target) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}