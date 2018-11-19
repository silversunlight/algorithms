package leetcode;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 10:54 2018/9/23
 * @Description：
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class ReverseWordsInStringIII557 {
    public String reverseWords(String s) {
        if (s == null || s.trim().equals("")) {
            return s;
        }
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            word = reverseOneWord(word);
            sb.append(" " + word);
        }
        return sb.toString().trim();
    }

    public String reverseOneWord(String s) {
        if (s == null || s.trim().equals("")) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "Let's take the leetcode contest";
        ReverseWordsInStringIII557 r = new ReverseWordsInStringIII557();
        System.out.println(r.reverseWords(s));
    }
}
