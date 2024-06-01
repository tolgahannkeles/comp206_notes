package midterm.data_structures;

public class ListBasedMap<K, V> {
    private Entry<K, V>[] entries;
    private int size;

    public ListBasedMap(int capacity) {
        entries = new Entry[capacity];
    }

    public V put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key)) {
                V oldValue = entries[i].value;
                entries[i].value = value;
                return oldValue;
            }
        }
        entries[size++] = new Entry<>(key, value);
        return value;
    }

    public V remove(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key)) {
                V oldValue = entries[i].value;
                for (int j = i; j < size - 1; j++) {
                    entries[j] = entries[j + 1];
                }
                size--;
                return oldValue;
            }
        }
        return null;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (entries[i].key.equals(key)) {
                return entries[i].value;
            }
        }
        return null;
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}