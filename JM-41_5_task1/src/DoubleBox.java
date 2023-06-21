public class DoubleBox <T> {
    private RandomBox<T> first;
    private RandomBox<T> second;

    public boolean put(int key, T value) {
        if (first == null) {
            first = new RandomBox<T>(key, value);
            return true;
        } if (second == null){
            second = new RandomBox<T>(key, value);
            return true;
        } else {
            return false;
        }
    }

    public T get(int key) {
        if (first != null && first.tryUnlock(key) != null) {
            return first.tryUnlock(key);
        } if (second != null && second.tryUnlock(key) != null) {
            return second.tryUnlock(key);
        } else {
            return null;
        }
    }

    public int size() {
        if (first != null && second != null) {
            return 2;
        } if (first != null || second != null){
            return 1;
        } else {
            return 0;
        }
    }
}
