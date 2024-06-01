package midterm.slide_codes;

public class Week6 {

    static class SimpleMap<K, V> {
        private Entry<K, V>[] entries;
        private int size;

        public SimpleMap(int capacity) {
            entries = new Entry[capacity];
        }

        public void put(K key, V value) {
            for (int i = 0; i < size; i++) {
                if (entries[i].key.equals(key)) {
                    entries[i].value = value;
                    return;
                }
            }
            entries[size++] = new Entry<>(key, value);
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
}
