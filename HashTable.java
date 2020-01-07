
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

            if (i + 1 == end && end != hash) {
                i = 0;
                System.out.println("end == hash && Inserting into index " + i);

                end = hash;
            }

            if (table[i] == null) {
                System.out.println("Inserting into index " + i);
                table[hash] = n;
                return;
            }

        }

    }

    public void increaseSize() {

        this.size++;
        Node<T, E>[] tmp = new Node[this.size];

        System.arraycopy(this.table, 0, tmp, 0, this.size);

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
    // public boolean get(String s) {

    // }

//    public boolean delete(String s) {
//        return false;
//    }

}