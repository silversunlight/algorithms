package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：Lance Sun
 * @date ：Created in 23:10 2018/10/16
 */

public class KeyboardRow500 {
    public String[] findWords(String[] words) {
        List<Set<Character>> list = new ArrayList<>();
        String[] strings = new String[]{
                "qwertyuiop",
                "asdfghjkl",
                "zxcvbnm"
        };
        //把键盘上的三排放入
        for (String line : strings) {
            Set<Character> set = new HashSet<>();
            for (Character c : line.toCharArray()) {
                set.add(c);
            }
            list.add(set);
        }
        List<String> result1 = Arrays.stream(words).parallel().filter(word -> {
            for (char c : word.toCharArray()) {
                if (!Character.isAlphabetic(c)) {
                    return false;
                }
            }
            return true;
        }).filter(word -> {
            boolean flag=false;
            for (Set<Character> set : list) {
                flag = true;
                for (char c : word.toLowerCase().toCharArray()) {
                    if (!set.contains(c)) {
                        flag = false;
                        continue;
                    }
                }
                if (flag == true) {
                    return true;
                }
            }
            return flag;
        }).collect(Collectors.toList());
        String[] result = new String[result1.size()];
        return result1.toArray(result);
    }

    public static void main(String[] args) {
        String[] a = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        KeyboardRow500 key = new KeyboardRow500();
        Arrays.stream(key.findWords(a)).forEach(word -> System.out.println(word + "\t"));
    }
}
