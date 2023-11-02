package practic19.task3;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("first");
        System.out.println(get(list, 0));
    }

    public static <T> T get(List<? extends T> list, int index) {
        return list.get(index);
    }
}
