import java.util.*;
public class Charreplace {
    public static  int CharacterReplace(String s, int k){
        int[] count = new int[26];
        int maxCount=0;
        int left=0;
        int maxLength=0;

        for (int right= 0; right< s.length(); right++) {
            int idx=s.charAt(right)-'A';
            count[idx]++;
            maxCount=Math.max(maxCount,count[idx]);

            if(right-left+1-maxCount>k){
                count[s.charAt(left) - 'A']--;
                left++;
            }maxLength=Math.max(maxLength, right-left+1);
            }
            return maxLength;
    }
    public static void main(String[] args) {
        String s="AABABBA";
        int k=1;
        System.out.println("the input string is "+s+" and k value is "+k);
        System.out.println("the output is "+ CharacterReplace(s,k));
    }
}
