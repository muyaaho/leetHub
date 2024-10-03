import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer> dp = new ArrayList<>();

        for (int num : nums) {
            int idx = findIndex(dp, num);
            if (dp.contains(num)) continue;

            if (dp.size() <= idx) dp.add(num);
            else dp.set(idx, num);
        }
        
        return dp.size();
    }

    private int findIndex(ArrayList<Integer> arr, int target) {
        int left = 0, right = arr.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (target < arr.get(mid)) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}