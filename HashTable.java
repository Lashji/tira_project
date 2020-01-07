
public class HashTable<T, E> {
    private Node<T, E>[] table;
    private int size;

    public HashTable() {
        this.size = 0;
        this.table = new Node[this.size];
    }

    public void insert(T key, E value) {
        Node<T, E> n = new Node<>(key, value);

        increaseSize();

        int hash = n.keyHash(this.size);
        System.out.println("Hashcode = " + hash);
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


//    public boolean find(String s) {
//        return false;
//    }

    public void print() {
        System.out.println("PRINTING FILES");
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.table[i]);
        }
    }

    public E get(T key) {
        for (Node i : this.table) {
            if (i.key() == key) {
                return (E) i.value();
            }
        }
        return null;
    }

//    public boolean delete(String s) {
//        return false;
//    }

}