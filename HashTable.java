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

    /**
     *  Inserts value into the hashtable
     * @param key
     * @param value
     */
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


    /**
     * Increases array size dynamically
     */
    public void increaseSize() {
        int oldsize = this.size;
        this.size++;
        Node<T, E>[] tmp = new Node[this.size];

        System.arraycopy(this.table, 0, tmp, 0, oldsize);

        this.table = tmp;
    }

    /**
     *  Finds Node from array with given key
     * @param key
     * @return index if found else return -1
     */
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

    /**
     * Method to find out if key is in hashtable
     * @param key
     * @return boolean
     */
    public boolean contains(T key) {
        return find(key) >= 0;
    }

    /**
     * Decreases HashTable size dynamically
     * @param nullIndex
     */
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

    /**
     * Returns node with given index
     * @param index
     * @return
     */
    public Node<T, E> get(int index) {
        if (index < 0 || index > this.size - 1) {
            return null;
        }

        return this.table[index];
    }

    /**
     * Prints all items
     */
    public void print() {
        for (int i = 0; i < this.size; i++) {
            System.out.println(this.table[i]);
        }
    }

    /**
     * Deletes item from array
     * @param key
     * @return boolean
     */
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

    /**
     *  Returns Node with given key
     * @param key
     * @return Node
     */
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

    /**
     * @return current arraySize
     */
    public int size() {
        return this.size;
    }

    /**
     * Prints array keys
     */
    public void printKeys(){
        for (int i = 0; i < this.table.length; i++) {
            if (this.table[i] != null)
                System.out.println(this.table[i].key());
        }
    }

    /**
     *
     * @return boolean
     */
    public boolean isEmpty(){
        return this.size < 1;
    }

}