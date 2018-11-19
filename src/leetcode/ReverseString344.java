package leetcode;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 11:27 2018/9/23
 * @Description：
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class ReverseString344 {
    public String reverseString(String s) {
        char[] words = s.toCharArray();
        int n = words.length - 1;
        for (int i = n >> 1; i >= 0; i--) {
            char temp = words[i];
            words[i] = words[n - i];
            words[n - i] = temp;
        }
        return new String(words);
    }
}
