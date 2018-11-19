package leetcode;

import java.util.*;

/**
 * @author ：Lance Sun
 * @date ：Created in 17:32 2018/10/16
 */
public class GroupOfSpecialEquivalentStrings893 {
    public int numSpecialEquivGroups(String[] A) {
        int count = 1;
        Map<String, String[]> map = new HashMap<>(1024);
        for (int index = 0; index < A.length; index++) {
            String string = A[index];
            //放偶数的
            char[] charSequence1 = new char[501];
            //放奇数的
            char[] charsequence2 = new char[501];
            for (int i = 0; i < string.length(); i++) {
                if ((i & 1) == 1) {
                    charSequence1[i >> 1] = string.charAt(i);
                }
                if ((i & 1) == 0) {
                    charsequence2[i >> 1] = string.charAt(i);
                }
            }
            Arrays.sort(charSequence1);
            Arrays.sort(charsequence2);
            if (index == 0) {
                map.put(string, new String[]{new String(charSequence1), new String(charsequence2)});
            }
            boolean flag = false;
            for (String[] strings : map.values()) {
                if (strings[0].equals(new String(charSequence1))
                        && strings[1].equals(new String(charsequence2))) {
                    flag = true;
                    break;
                }
            }
            //flag为true，说明已经存在了
            if (!flag) {
                map.put(string, new String[]{new String(charSequence1), new String(charsequence2)});
                count++;
            }
        }
        return count;
    }

    public int easySolver(String[] A) {
        Set<String> set = new HashSet<>();
        for (String s : A) {
            int[] odd = new int[26];
            int[] even = new int[26];
            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 1) odd[s.charAt(i) - 'a']++;
                else even[s.charAt(i) - 'a']++;
            }
            String sig = Arrays.toString(odd) + Arrays.toString(even);
            set.add(sig);
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] A = new String[]{"aa", "bb", "ab", "ba"};
        GroupOfSpecialEquivalentStrings893 a = new GroupOfSpecialEquivalentStrings893();
        int b = a.easySolver(A);
        System.out.println(b);
    }
}
