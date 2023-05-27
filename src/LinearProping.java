import java.util.ArrayList;

public class LinearProping {
    private String[] hashTable;
    private int usedCells;

    private int size;

    public LinearProping(int size) {
        hashTable = new String[size];
        usedCells = 0;
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

    //rehashing method if load factor exceeds .75
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
                insertHashTable(string);
            }
        }
    }

    public void insertHashTable(String word) {
        if (getLoadFactor() >= .75) {
            rehashKeys(word);
        } else {
            int index = modASCIIHashFunction(word);
            for (int i = index; i < index + size; i++) {
                int newIndex = i % size;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.printf("\"%s\" INSERTED AT %d%s  INDEX\n", word, newIndex + 1, newIndex == 0 ? "st" : newIndex == 1 ? "nd" :
                            newIndex == 2 ?
                                    "rd" : "th");
                    break;
                } else {
                    System.out.printf("%d INDEX OCCUPIED\n", newIndex);
                }
            }
            usedCells++;
        }
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

    public boolean contains(String word) {
        int index = modASCIIHashFunction(word);
        for (int i = index; i < size + index; i++) {
            int newIndex = i % size;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                return true;
            }
        }
        return false;
    }

    public void deleteKey(String word) {
        int index = modASCIIHashFunction(word);
        for (int i = index; i < size + index; i++) {
            int newIndex = i % size;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                hashTable[newIndex] = null;
                System.out.printf("\"%s\" was removed from the table", word);
                return;
            }
        }
        System.out.printf("\"%s\" was not found on the table", word);

    }


}
