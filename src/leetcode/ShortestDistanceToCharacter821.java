package leetcode;

import java.util.Arrays;

/**
 * @author ：Lance Sun
 * @date ：Created in 22:28 2018/10/16
 */
public class ShortestDistanceToCharacter821 {
    public int[] shortestToChar(String S, char C) {
        char[] charSequence = S.toCharArray();
        int[] result = new int[S.length()];
        for (int i = 0; i < charSequence.length; i++) {
            //如果相等直接就是0
            if (charSequence[i] == C) {
                result[i] = 0;
                //不相等的话向左右查找
            } else {
                int left = 0;
                boolean flag1 = false;
                //向左找
                for (int j = i; j >= 0; j--) {
                    if (charSequence[j] == C) {
                        flag1 = true;
                        break;
                    }
                    left++;
                }
                int right = 0;
                boolean flag2 = false;
                //向右找
                for (int k = i; k < charSequence.length; k++) {
                    if (charSequence[k] == C) {
                        flag2 = true;
                        break;
                    }
                    right++;
                }
                //都为true
                if (flag1 && flag2) {
                    result[i] = Math.min(left, right);
                    //从左侧找到了
                } else if (flag1) {
                    result[i] = left;
                } else if (flag2) {
                    result[i] = right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ShortestDistanceToCharacter821 a = new ShortestDistanceToCharacter821();
        String s = "baaa";
        char c = 'b';
        int[] res = a.shortestToChar(s, c);
        Arrays.stream(res).forEachOrdered(i -> System.out.print(i + "\t"));
    }
}
