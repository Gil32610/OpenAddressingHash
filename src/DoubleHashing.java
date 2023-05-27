import java.util.ArrayList;

public class DoubleHashing {

    private String[] hashTable;
    private int usedCells;
    private int size;


    public DoubleHashing(int size) {
        this.hashTable = new String[size];
        this.usedCells = 0;
        this.size = size;
    }

    public int modASCIIHashFunction(String word) {
        char ch[];
        ch = word.toCharArray();

        int i, sum;
        for (sum = 0, i = 0; i < word.length(); i++) {
            sum += ch[i];
        }
        return sum % size;
    }

    public double getLoadFactor() {
        return usedCells * 1 / size;
    }

    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("EMPTY");
            return;
        } else {
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index: " + i + ", Key: " + hashTable[i]);
            }
        }
    }


    private void rehashKeys(String word) {
        usedCells = 0;
        ArrayList<String> data = new ArrayList<String>();
        for (String s : hashTable) {
            if (s != null) {
                data.add(s);
            }
            data.add(word);
            hashTable = new String[size * 2];
            for (String string : data) {
                insertKey(string);
            }
        }
    }


    private int sumAllDigits(int number) {
        int value = 0;
        while (number > 0) {
            value = number % 10;
            number /= 10;
        }
        return value;
    }

    public int secondHashing(String word) {
        char[] ch;
        ch = word.toCharArray();
        int i, sum;
        for (i = 0, sum = 0; i < word.length(); i++) {
            sum += ch[i];
        }
        while (sum > size) {
            sum = sumAllDigits(sum);
        }
        return sum % size;
    }

    public void insertKey(String word) {
        if (getLoadFactor() >= .75) {
            rehashKeys(word);
        } else {
            int firstHash = modASCIIHashFunction(word);
            int secondHash = secondHashing(word);
            for (int i = 0; i < size; i++) {
                int newIndex = (firstHash + i * secondHash) % size;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    usedCells++;
                    System.out.printf("\"%s\" was inserted in %d index", word, i);
                    break;
                } else {
                    System.out.printf("%d is occupied", i);
                }
            }
        }
    }

}
