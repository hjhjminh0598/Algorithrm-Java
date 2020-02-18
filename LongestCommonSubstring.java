package algorithrm;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String str1 = "sdwacz";
        String str2 = "aszsdwaca";
        String str3 = "asasdwcz";
        String str4 = "bsdavasdw";
        System.out.println(longestSubStr(str1, longestSubStr(str2, longestSubStr(str3, str4))));
    }

    public static String longestSubStr(String str1, String str2) { //sdwaca, aszsdwaca, asasdwcz, bsdavasdw
        int lengthStr1 = str1.length(), lengthStr2 = str2.length();
        String result = "";
        int maxLength = 0;
        boolean breakAll = false;
        for (int i = 0; i < lengthStr1; i++) {
            if (breakAll) break;
            int tempLength = 0;
            final int index = i;// index to keep value of i when i++ when appear same sub string
            String tempSubStr = "";
            for (int j = 0; j < lengthStr2; j++) {
                if (str2.charAt(j) == str1.charAt(i)) {
                    tempLength++;
                    tempSubStr += str2.charAt(j);
                    if (i < lengthStr1 - 1) {
                        i++;
                    } else { //special case
                        if (tempLength > maxLength) {
                            maxLength = tempLength;
                            result = tempSubStr;
                        }
                        breakAll = true;
                        break;
                    }
                    if (j == lengthStr2 - 1) { //special case
                        if (tempLength > maxLength) {
                            maxLength = tempLength;
                            result = tempSubStr;
                        }
                        i = index;
                        tempLength = 0;
                        tempSubStr = "";
                    }
                } else {
                    if (tempLength > maxLength) {
                        maxLength = tempLength;
                        result = tempSubStr;
                    }
                    tempLength = 0;
                    tempSubStr = "";
                    if (i != index) {
                        j--;         // Ex: "aszs" & "asasz", (j = 2) != (i = 2) so if have no j-- => j = 3('s') and we ignor case "asz"
                        i = index;
                    }
                }
            }
        }
        return result;
    }
}
