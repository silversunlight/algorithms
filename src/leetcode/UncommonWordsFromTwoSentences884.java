package leetcode;

import suanfabiji.LIS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Lance Sun
 * @date ：Created in 17:13 2018/10/17
 */
public class UncommonWordsFromTwoSentences884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] a = A.split(" ");
        String[] b = B.split(" ");
        Map<String, Integer> c = new HashMap<>(512);
        traversal(a, c);
        traversal(b, c);
        List<String> res = new ArrayList<>();
        for (Map.Entry entry : c.entrySet()) {
            if ((int) entry.getValue() < 2) {
                res.add((String) entry.getKey());
            }
        }
        return res.toArray(new String[res.size()]);
    }

    private void traversal(String[] a, Map<String, Integer> c) {
        for (String s : a) {
            if (c.get(s) == null) {
                c.put(s, 1);
            } else {
                c.put(s, c.get(s) + 1);
            }
        }
    }

    public static void main(String[] args) {
        String A = "this apple is sweet";
        String B = "this apple is sour";
        UncommonWordsFromTwoSentences884 a = new UncommonWordsFromTwoSentences884();
        String[] c = a.uncommonFromSentences(A, B);
    }
}
