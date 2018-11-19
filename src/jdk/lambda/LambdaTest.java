package jdk.lambda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Lance Sun
 * @date Created in 20:52 2018/10/24
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<Set<Integer>> list = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        Set<Integer> set3 = new HashSet<>();
        set3.add(3);
        list.add(set1);
        list.add(set2);
        list.add(set3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        list2 = list2.stream().filter(i -> {
            for (Set<Integer> set : list) {
                if (set.contains(i)) {
                    return true;
                } else {
                    continue;
                }
            }
            return false;
        }).collect(Collectors.toList());
        list2.stream().forEachOrdered(i -> System.out.println(i));
    }
}
