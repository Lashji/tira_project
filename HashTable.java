import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
                table[i] = n;
                return;
            }

            if (i + 1 == end) {
                i = 0;
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
        this.size--;
        ArrayList<Node<T,E>> tmpList = new ArrayList<>();
        Collections.addAll(tmpList, this.table);
        tmpList.remove(nullIndex);

        Node<T,E>[] tmp = new Node[tmpList.size()];
       for (int i = 0; i < tmpList.size(); i++) {
            tmp[i] = tmpList.get(i);
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
        System.out.println("returning false from delete");
        return false;
    }

    public E get(T key) {
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

    public void printKeys(){
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] != null)
                System.out.println(this.table[i].key());
        }
    }

    public boolean isEmpty(){
        return this.size < 1;
    }

}