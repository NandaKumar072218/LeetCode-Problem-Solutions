import java.util.HashMap;
import java.util.Map;
public class Longestsub {

    public static int lengthOfLongestSubstring(String s) {
        //Hashmap used to store the appearens of element in array at which index
    Map<Character, Integer> lastAppear = new HashMap<>();
    int left = 0;
    int maxLen = 0;

    for (int right = 0; right < s.length(); right++) {
        char c = s.charAt(right);

        // if duplicate found inside window
        if (lastAppear.containsKey(c)) {
            left = Math.max(left, lastAppear.get(c) + 1);
        }
        //adds the lastappaer of element in the array to Hashmap
        lastAppear.put(c, right);
        maxLen = Math.max(maxLen, right - left + 1);
    }

    return maxLen;
}
public static void main(String[] args) {
        //input of different types on test-case
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";

        System.out.println("Input: " + s1 + " → Output: " + lengthOfLongestSubstring(s1));
        System.out.println("Input: " + s2 + " → Output: " + lengthOfLongestSubstring(s2));
        System.out.println("Input: " + s3 + " → Output: " + lengthOfLongestSubstring(s3));
    }

}