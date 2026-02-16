import java.util.*;
public class Contsubarray {

    public static long continuousSubarrays(int[] nums) {

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        long count = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain decreasing deque for maximum
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain increasing deque for minimum
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // Shrink window if condition breaks
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            // Count valid subarrays ending at right
            count += (right - left + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {5, 4, 2, 4};

        long result = continuousSubarrays(nums);

        System.out.println("Total Continuous Subarrays: " + result+" subarrays");
    }


}
