
import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Tira2019 {
    private ArrayList<String> readInput(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
        } catch (IOException e) {
            System.out.println("File not found.");

        }
        return lines;
    }

    private void writeOutput(HashTable<String, Integer> lines, String filename) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));

            for (int i = 0; i < lines.size(); i++) {
                bw.write(lines.get(i).toString());
                bw.newLine();
            }

            bw.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
        System.out.println("Writing file...");
    }

    public static void main(String[] args) {
        Tira2019 ht = new Tira2019();

        ArrayList<String> setA = ht.readInput("setA.txt");
        ArrayList<String> setB = ht.readInput("setB.txt");

        HashTable<String, String> hashtable = new HashTable<String, String>();
//        test(hashtable);


        XorUtils xor = new XorUtils(setA, setB);


        HashTable<String, Integer> orLines = xor.or();
        HashTable<String, Integer> xorLines = xor.xor();
        HashTable<String, Integer> andLines = xor.and();

        ht.writeOutput(orLines, "or.txt");
        ht.writeOutput(andLines, "and.txt");
        ht.writeOutput(xorLines, "xor.txt");
    }


    public static void test(HashTable<String, String> hashtable) {
        System.out.println("inserting");
        hashtable.insert("key", "value");
        hashtable.insert("rrgrg", "jt");
        hashtable.insert("key", "value");
        hashtable.insert("2", "jtf");
        hashtable.insert("1", "value2");
        hashtable.insert("ghk", "333");

        System.out.println("====== GETTING: ======");
        System.out.println(hashtable.get("rrgrg"));
        System.out.println(hashtable.get("key"));
        System.out.println(hashtable.get("69"));
        System.out.println("======= end GEtting==========");


        System.out.println("====== FINDING: ======");
        System.out.println(hashtable.contains("rrgrg"));
        System.out.println(hashtable.contains("key"));
        System.out.println(hashtable.contains("69"));
        System.out.println("======= end FINDING==========");

        System.out.println("====== DELETING: ======");
        System.out.println(hashtable.delete("rrgrg"));
        System.out.println(hashtable.delete("key"));
        System.out.println(hashtable.delete("69"));
        System.out.println("======= end DELETING==========");


        System.out.println("====== FINDING: ======");
        System.out.println(hashtable.contains("rrgrg"));
        System.out.println(hashtable.contains("key"));
        System.out.println(hashtable.contains("69"));
        System.out.println("======= end FINDING==========");

        hashtable.print();
    }

}