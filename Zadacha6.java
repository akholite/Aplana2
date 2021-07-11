import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Zadacha6 {

        public static void main(String[] args) throws FileNotFoundException {

            //если кириллица не читаются, необходимо убедиться, что кодировка = utf-8
            File dataFile = new File("text.txt");
            Scanner reader = new Scanner(dataFile);
            SortedMap<String, Integer> wordFrequency = new TreeMap<String, Integer>();

            String nextWord = null;
            String mostFrequentWord = null;

            while (true) {
                try {
                    nextWord = reader.next();
                } catch (NoSuchElementException e) {
                    break;
                }

                if (wordFrequency.containsKey(nextWord)) {
                    wordFrequency.replace(nextWord, wordFrequency.get(nextWord) + 1);
                } else {
                    wordFrequency.put(nextWord, 1);
                }

                try {
                    if (wordFrequency.get(nextWord) > wordFrequency.get(mostFrequentWord)) {
                        mostFrequentWord = nextWord;
                    }
                } catch (NullPointerException e) {
                    mostFrequentWord = nextWord;
                }
            }

            try {

                System.out.println("Статистика частоты слов в файле в алфавитном порядке:");
                System.out.println("Частота     Слово\n-----------------------------");

                for (String word : wordFrequency.keySet()) {
                    System.out.printf("%-12d%s\n", wordFrequency.get(word), word);
                }

                int max = wordFrequency.get(mostFrequentWord);
                System.out.println("Самые часто встречающиеся слова:");

                for (String word : wordFrequency.keySet()) {
                    if (wordFrequency.get(word) == max)
                        System.out.println(word);
                }
                System.out.println("встречаются " + wordFrequency.get(mostFrequentWord) + " раз");
            }
            catch (NullPointerException e) {
                System.out.println("Файл пуст");
            }

            reader.close();
        }
}
