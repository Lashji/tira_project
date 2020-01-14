
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
        Scanner sc = new Scanner(System.in);

        ArrayList<String> setA = ht.readInput("setA.txt");
        ArrayList<String> setB = ht.readInput("setB.txt");
//
//        HashTable<String, String> hashtable = new HashTable<String, String>();
//        test(hashtable);


        XorUtils xor = new XorUtils(setA, setB);


        HashTable<String, Integer> orLines = xor.or();
        HashTable<String, Integer> xorLines = xor.xor();
        HashTable<String, Integer> andLines = xor.and();

//      UI
        while (true) {
            System.out.println("Hello!\n" +
                    "Type one of the options below to continue\n" +
                    "=========================================\n"+
                    "write : Program writes the data into files\n" +
                    "delete : Delete nodes from the data\n" +
                    "quit : Program quits without writing\n" +
                    "=========================================\n"+
                    "Or has " + orLines.size() + " values\n" +
                    "Xor has " + xorLines.size() + " values\n" +
                    "And has " + andLines.size() + " values\n" +
                    "=========================================\n"
            );

                    String option = sc.nextLine();

            if (option.toLowerCase().equals("quit")) {
                break;
            }

            if (option.toLowerCase().equals("write")) {
                ht.writeOutput(orLines, "or.txt");
                ht.writeOutput(andLines, "and.txt");
                ht.writeOutput(xorLines, "xor.txt");
                break;
            }

            if (option.toLowerCase().equals("delete")) {
                System.out.println("Type number to select where you want to delete values from: \n");

                while (true) {
                System.out.println("1. Or\n" +
                        "2. Xor\n" +
                        "3. And");
                    boolean d = false;

                    String deleteFrom = sc.nextLine();

                    if (deleteFrom.toLowerCase().equals("1") || deleteFrom.toLowerCase().equals("or")) {
                        d = ht.delete(orLines, sc);
                    }
                    if (deleteFrom.toLowerCase().equals("2")) {
                         d = ht.delete(xorLines, sc);
                    }

                    if (deleteFrom.toLowerCase().equals("3")) {
                         d = ht.delete(andLines, sc);
                    }

                    if (d) {
                        break;
                    }
                    System.out.println("You need to select one of the 3 options");

                }

            }
        }


    }

    /**
     *
     * @param lines
     * @param sc
     * @return true if delete was successful else false
     */
    public boolean delete(HashTable<String, Integer> lines, Scanner sc){
        if (lines.isEmpty()){
            System.out.println("No values");
            return false;
        }
        lines.printKeys();

        String d = sc.nextLine();
        if (lines.contains(d)) {
            lines.delete(d);
            return true;
        } else {
            System.out.println("Value does not exist");
            return false;
        }
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