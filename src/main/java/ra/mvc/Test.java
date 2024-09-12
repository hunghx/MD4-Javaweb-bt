package ra.mvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("chuối","táo","bưởi","cam");
        List<Integer> lengths = fruits.stream()
                .map(String::length).collect(Collectors.toList());


        // flatMap = flat (làm phẳng stream) + map
       List<List<Integer>> numbers = Arrays.asList(
               Arrays.asList(1,2,3,4),
              Arrays.asList(5,6,7,8)
       );

       List<Integer> number = numbers.stream().flatMap(t->t.stream())
               .collect(Collectors.toList());
    }
}
