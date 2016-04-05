package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import task2.constants.Const;

public class WordFrequency {

    private Map<String, Integer> wordsMap = new HashMap<String, Integer>();

    public WordFrequency(String text) {
        set(text);
    }

    public WordFrequency(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader(file));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            set(line);
        }
    }

    private void set(String text) {
        Pattern p = Pattern.compile(Const.REGEX);
        Matcher m = p.matcher(text);
        while (m.find()) {
            String word = m.group(Const.INDEX_TWO).toLowerCase();
            if (wordsMap.containsKey(word)) {
                int frequency = wordsMap.get(word);
                wordsMap.put(word, Const.FREQUENCY_DEFAULT + frequency);
            } else {
                wordsMap.put(word, Const.FREQUENCY_DEFAULT);
            }
        }
    }

    public Map<String, Integer> getWordsMap() {
        return wordsMap;
    }

    public String searchWord(Map<String, Integer> wordsMap, String findWord, Enum variant) {

        findWord = findWord.toLowerCase();
        switch (variant.ordinal()) {
            case Const.ZERO:
                if (wordsMap.containsKey(findWord)) {
                    return findWord;
                }
                break;
            case Const.ONE:
                if (wordsMap.get(findWord) != null) {
                    return findWord;
                }
                break;
            default:
                for (String key : wordsMap.keySet()) {
                    if (key.equals(findWord)) {
                        return key;
                    }
                }
        }
        throw new NoSuchElementException(Const.NOT_FOUND);
    }

    public int searchFrequency(String key) {
        return wordsMap.get(key);
    }

}
