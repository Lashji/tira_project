
public class HashTable<T, E> {
    private Node<T, E>[] table;
    private int size;

    public HashTable() {
        this.size = 0;
        this.table = new Node[this.size];
    }

    public void insert(T key, E value) {
        Node<T, E> n = new Node<>(key, value);

        int index = find(key);
        if (index >= 0) {
            table[index] = n;
            return;
        }

        increaseSize();

        int hash = n.keyHash(this.size);

        int end = this.size;

        if (table[hash] == null) {
            table[hash] = n;
            return;
        }

        for (int i = hash; i < end; i++) {

            if (table[i] == null) {
                System.out.println("Inserting into index " + i);
                table[i] = n;
                return;
            }

            if (i + 1 == end) {
                i = 0;
                System.out.println("Settings index to 0 && Inserting into index " + i);
                end = hash;
            }
        }

    }

    public void increaseSize() {
        int oldsize = this.size;
        this.size++;
        Node<T, E>[] tmp = new Node[this.size];

        System.arraycopy(this.table, 0, tmp, 0, oldsize);

        this.table = tmp;
    }


    private int find(T key) {
        for (int i = 0; i < this.size; i++) {
            if (this.table[i] != null) {
                if (this.table[i].key().equals(key)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public boolean contains(T key) {
        return find(key) >= 0;
    }

    private void decreaseSize(int nullIndex) {
        int j = 0;
        this.size--;
        Node[] tmp = new Node[this.size];
        for (int i = 0; i < this.table.length; i++) {

            if (i == nullIndex) {
                i++;
            }
            tmp[j] = this.table[i];
            j++;
        }

        this.table = tmp;
    }


    public Node<T, E> get(int index) {
        if (index < 0 || index > this.size - 1) {
            return null;
        }

        return this.table[index];
    }

    public void print() {
        System.out.println("PRINTING FILES");
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.table[i]);
        }
    }


    public boolean delete(T key) {
        int index = find(key);

        if (index >= 0) {
            this.table[index] = null;
            decreaseSize(index);
            return true;
        }

        return false;
    }

    public E get(T key) {
        System.out.printf("get T");
        for (Node i : this.table) {
            if (i != null) {

                if (i.key().equals(key)) {
                    return (E) i.value();
                }
            }
        }
        return null;
    }

    public int size() {
        return this.size;
    }

}