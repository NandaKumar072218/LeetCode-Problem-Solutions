import java.util.HashSet;
import java.util.Set;

public class Containduplicate2 {

    /**
     * Returns true if there exist two distinct indices i and j such that:
     * nums[i] == nums[j] AND abs(i - j) <= k
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        // This set will store at most 'k' previous elements
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // If element already exists in the window,
            // it means duplicate found within last k indices
            if (window.contains(nums[i])) {
                return true;
            }

            // Add current element into window
            window.add(nums[i]);

            // Maintain window size of at most k
            if (window.size() > k) {
                // Remove the element that is k distance behind
                window.remove(nums[i - k]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = { 99, 1, 2, 3, 1, 99, 2, 3, 99, 1, 2, 99 };
        int k = 4;

        // For different test cases commented below
        // int[] nums0=[1, 2, 3, 1];
        // int k0= 3;

        // int[] nums1 = { 1, 0, 1, 1 };
        // int k1 = 1;

        // int[] nums2 = { 1, 2, 3, 4, 5 };
        // int k2 = 3;

        // int[] nums3 = { 1, 2, 3, 1 };
        // int k3 = 3;

        // int[] nums4 = { 2, 3, 4 };
        // int k4 = 2;

        // int[] nums5 = { 2, 3, 4 };
        // int k5 = 3;

        // int[] nums6 = { 2, 3, 4 };
        // int k6 = 4;

        boolean result = containsNearbyDuplicate(nums, k);

        System.out.println("Input Array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }

        System.out.println("\n\nk = " + k);
        System.out.println("\nContains Nearby Duplicate: " + result);
    }
}