package Hash;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String phrase = "Paranoids are not paranoid because they are paranoid " +
                "but because they keep putting themselves deliberately into " +
                "paranoid avoidable situations";

        String[] words = phrase.split(" ");

        MyHashMap<String, Integer> wordFrequencyMap = new MyHashMap<>(10);

        for (String word : words) {
            Integer frequency = wordFrequencyMap.get(word);
            if (frequency == null) {
                wordFrequencyMap.insert(word, 1);
            } else {
                wordFrequencyMap.insert(word, frequency + 1);
            }
        }

        System.out.println("Word Frequencies:");
        for (String word : words) {
            Integer frequency = wordFrequencyMap.get(word);
            System.out.println(word + ": " + frequency);
        }

        // Remove the word "avoidable"
        wordFrequencyMap.remove("avoidable");

        System.out.println("\nWord Frequencies after removal:");
        for (String word : words) {
            Integer frequency = wordFrequencyMap.get(word);
            System.out.println(word + ": " + frequency);
        }
    }
}
