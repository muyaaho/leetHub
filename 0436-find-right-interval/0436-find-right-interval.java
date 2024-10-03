import java.util.*;

class Solution {
    ArrayList<Integer> sarr;
    public int[] findRightInterval(int[][] intervals) {
        int[] answer = new int[intervals.length];
        ArrayList<Integer> arr = new ArrayList<>();
        for (int[] interval: intervals) {
            arr.add(interval[0]);
        }

        sarr = new ArrayList<>(arr);
        Collections.sort(sarr);
        // System.out.println(arr);
        // System.out.println(sarr);
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int idx = findIdx(end);
            
            

            if (idx >= intervals.length) {
                answer[i] = -1;
                continue;
            }
            answer[i] = arr.indexOf(sarr.get(idx));
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

        // System.out.println("end: " + target + ", idx: " + (left));

        return left;
    }
}