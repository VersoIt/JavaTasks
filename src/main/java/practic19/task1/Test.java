package practic19.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static <T> List<T> convertToList(T[] array) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }
}

