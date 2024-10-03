import java.util.*;

class Solution {
    ArrayList<Integer> sarr;
    public int[] findRightInterval(int[][] intervals) {
        int[] answer = new int[intervals.length];
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> dict = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            dict.put(intervals[i][0], i);
            arr.add(intervals[i][0]);
        }

        sarr = new ArrayList<>(arr);
        Collections.sort(sarr);

        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int idx = findIdx(end);
            
            if (idx >= intervals.length) {
                answer[i] = -1;
                continue;
            }
 
            answer[i] = dict.get(sarr.get(idx));
        }
        return answer;
    }

    private int findIdx(int target) {
        int left = 0, right = sarr.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (sarr.get(mid) < target) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return left;
    }
}