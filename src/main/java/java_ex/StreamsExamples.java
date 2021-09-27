package java_ex;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,7,4,3,6,5,0,8);
        Map<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("e",5);
        map.put("f",6);
        Set<String> set = map.keySet();
        Queue<String> queue = new LinkedList<>(set);

        Stream<Integer> intStream = list.stream();
        //list.stream().forEach(e -> System.out.println(e*2));

        System.out.println(list.stream().map(e -> e*3).collect(Collectors.toList()));
        System.out.println(list.stream().filter(e -> e%2==0).collect(Collectors.toList()));

    }
}
