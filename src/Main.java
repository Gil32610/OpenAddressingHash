public class Main {
    public static void main(String[] args) {
        LinearProping linearProping = new LinearProping(10);
        String[] words = {"Here", "are", "the", "best", "no-pull", "dog", "harnesses", "you", "can", "buy"};
        for (int i = 0; i < words.length ; i++) {
            linearProping.insertHashTable(words[i]);
        }
        linearProping.displayHashTable();
    String word = "doag";
        System.out.printf("\"%s\" %s",word, linearProping.contains(word)?" was found":" was not found");

        QuadraticProbing quadraticProbing = new QuadraticProbing(20);
        for (int i = 0; i < words.length ; i++) {
            quadraticProbing.insertKey(words[i]);
        }
        quadraticProbing.displayHashTable();

    }
}
