import java.util.Collection;
import java.util.Collections;

public class LongestSameChar {
    public static void main(String[] args) {
        int[] idx = longestSubString("aabbbcdccc");
        System.out.println(idx[0] + " " + idx[1]);
    }

    public static int[] longestSubString(String s) { // aabcdccccd
        int l = s.length();
        int[] result = new int[2];
        int start = 0, end = 0, max = 0;
        for (int i = 0; i < l - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                end = i + 2;
                if (i == l - 2 && max < end - start) {
                    return new int[]{start, end};
                }
                continue;
            } else if (max < end - start) {
                max = end - start;
                result[0] = start;
                result[1] = end;
                start = i + 1;
                end = i + 2;
            } else {
                start = i + 1;
                end = i + 2;
            }
        }
        return result;
    }
} //Giang edit from github

