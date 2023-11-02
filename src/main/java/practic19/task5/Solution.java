package practic19.task5;

import java.util.*;

class A {

}

class B extends A {

}

public class Solution<T, K, V> {

    public static void main(String[] args) {
        Solution<Integer, A, B> solution = new Solution<>();
        Map<A, B> a = solution.newMap(new Pair<>(null, null), new Pair<>(null, null));
    }

    @SafeVarargs
    public static <T> boolean addAll(Collection<? super T> c, T... elements) {
        boolean result = false;
        for (T element : elements)
            result |= c.add(element);
        return result;
    }

    @SafeVarargs
    public final Map<K, V> newMap(Pair<K, V>... elements) {
        Map<K, V> map = new HashMap<>();
        for (Pair<K, V> e : elements) {
            map.put(e.key(), e.value());
        }
        return map;
    }

    @SafeVarargs
    public final List<T> newList(T... elements) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, elements);
        return list;
    }
}