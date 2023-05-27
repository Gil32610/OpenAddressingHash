public class Main {
    public static void main(String[] args) {
        LinearProping linearProping = new LinearProping(10);
        String[] words = {"Here", "are", "the", "best", "no-pull", "dog", "harnesses", "you", "can", "buy"};
        for (int i = 0; i < words.length ; i++) {
            linearProping.insertHashTable(words[i]);
        }

    }
}
