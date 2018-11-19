package leetcode;

import java.util.*;

/**
 * @Author ：Lance Sun
 * @Date ：Created in 10:45 2018/9/25
 * @Description：
 * @ModifiedBy：
 * @Version: 1.0.0
 */
public class SubdomainVisitCount811 {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>(32);
        for (String s : cpdomains) {
            int num = Integer.parseInt(s.split(" ")[0]);
            String domain = s.split(" ")[1];
            StringBuilder tmp = new StringBuilder(domain);
            for (; ; ) {
                int a = tmp.indexOf(".");
                if (a == -1) {
                    if (map.containsKey(tmp.toString())) {
                        int ddd = map.get(tmp.toString()) + num;
                        map.put(tmp.toString(), ddd);
                    } else {
                        map.put(tmp.toString(), num);
                    }
                    break;
                } else {
                    if (map.containsKey(tmp.toString())) {
                        int ddd = map.get(tmp.toString()) + num;
                        map.put(tmp.toString(), ddd);
                    } else {
                        map.put(tmp.toString(), num);
                    }
                    tmp = new StringBuilder(tmp.substring(a+1));
                }
            }
        }
        List<String> rst = new ArrayList<>();
        for (Map.Entry<String, Integer> eee : map.entrySet()) {
            String s2 = eee.getKey();
            Integer aaa = eee.getValue();
            String tmp = aaa.toString() + " " + s2;
            rst.add(tmp);
        }
        return rst;
    }

    public static void main(String[] args) {
        String[] domains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> rst = subdomainVisits(domains);
        rst.spliterator().forEachRemaining(s -> System.out.println(s));
    }
}
