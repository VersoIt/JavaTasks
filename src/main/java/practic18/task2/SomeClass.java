package practic18.task2;

public class SomeClass<T, V, K> {

    private final K key;

    private final T metadata;

    private final V value;

    public SomeClass(T metadata, V value, K key) {
        this.metadata = metadata;
        this.value = value;
        this.key = key;
    }

    public void printAllTypes() {
        System.out.println(metadata.getClass().getName());
        System.out.println(value.getClass().getName());
        System.out.println(key.getClass().getName());
    }

    public T getMetadata() {
        return metadata;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }
}
