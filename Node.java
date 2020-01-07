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

    public int keyHash(int count) {
        System.out.println("COUNT = "+ count);
        return this.key.hashCode() % count;
    }

    @Override
    public String toString() {
        return this.key + " : " + this.value;
    }

}