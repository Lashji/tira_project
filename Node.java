public class Node<T, E> {
    private T key;
    private E value;

    public Node(T key, E value) {
        this.key = key;
        this.value = value;
    }

    public T key() {
        return this.key;
    }

    public void key(T key) {
        this.key = key;
    }

    public void value(E value) {
        this.value = value;
    }

    public E value() {
        return this.value;
    }

    /**
     *
     * @param count
     * @return hash for the key
     */
    public int keyHash(int count) {
        return Math.abs(this.key.hashCode() % count);
    }

    @Override
    public String toString() {
        return this.key + "\t" + this.value;
    }

}