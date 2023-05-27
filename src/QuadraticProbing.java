import java.util.ArrayList;

public class QuadraticProbing {
    private String[] hashTable;
    int usedCells;

    int size;
    public QuadraticProbing(int size){
        this.hashTable = new String[size];
        usedCells=0;
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

    public void insertKey(String word){
    if(getLoadFactor()>=.75){
        rehashKeys(word);
    }else{
        int index = modASCIIHashFunction(word);
        int counter = 0;
        for (int i = index; i <size+index ; i++) {
            int newIndex = (index + (counter* counter))%size;
            if(hashTable[newIndex] == null){
                hashTable[newIndex] = word;
                usedCells++;
                System.out.printf("\"%s\" was added to the hash table",word);
               break;
            }else{
                System.out.printf("%d index occupied",newIndex);
            }
            counter++;
        }

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
}
