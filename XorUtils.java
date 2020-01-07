import java.util.ArrayList;

public class XorUtils {


    private ArrayList<String> setA;
    private ArrayList<String> setB;


    public XorUtils(ArrayList<String> setA, ArrayList<String> setB) {
        this.setA = setA;
        this.setB = setB;
    }

    public  HashTable<String, Integer> or() {
        HashTable<String, Integer> hashtable = new HashTable<String, Integer>();

        for (String line : this.setA) {

            if (hashtable.contains(line)) {
                hashtable.insert(line, hashtable.get(line) + 1);
            } else {
                hashtable.insert(line, 1);
            }
        }

        for (String line : this.setB) {

            if (hashtable.contains(line)) {
                hashtable.insert(line, hashtable.get(line) + 1);
            } else {
                hashtable.insert(line, 1);
            }
        }
        return hashtable;

    }

    public  HashTable<String, Integer> and() {
        ArrayList<String> lines = new ArrayList<>();

        HashTable<String, Integer> hashtable = new HashTable<String, Integer>();

        int index = 0;

        for (String line : setA){
            if (setB.contains(line) && !hashtable.contains(line)){
                hashtable.insert(line,index);
            }
            index++;
        }

        return hashtable;

    }

    public  HashTable<String, Integer> xor() {

        HashTable<String, Integer> hashtable = new HashTable<String, Integer>();

        for (String line: setA){
            if (!setB.contains(line)){
                hashtable.insert(line, 1);
            }
        }
        for (String line: setB){
            if (!setA.contains(line)){
                hashtable.insert(line, 2);
            }
        }
        return hashtable;
    }

    private HashTable<String, Integer> getTable(){
        HashTable<String, Integer> hashtable = new HashTable<String, Integer>();
        return hashtable;

    }
}
