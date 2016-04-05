package task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.NoSuchElementException;
import task2.constants.Const;
import task2.enums.VariantSearch;

public class Runner {

    public static void main(String[] args) {

        final String SEARCH_ELEMENT = "hOuSe";

        try {
            //source = string line
            //WordFrequency wf = new WordFrequency(Const.TEXT);

            //source = file
            File file = new File(Const.PATH_FILE);

            WordFrequency wf = new WordFrequency(file);
            Map<String, Integer> wordsMap = wf.getWordsMap();

            //print map to console: format (key | value) 
            //for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            //System.out.println(entry.getKey() + Const.DELIMITER + entry.getValue());
            //}
            String findWord = wf.searchWord(wordsMap, SEARCH_ELEMENT, VariantSearch.DEFAULT);
            int findFrequency = wf.searchFrequency(findWord);
            System.out.println(findWord + Const.DELIMITER + findFrequency);

        } catch (FileNotFoundException | NoSuchElementException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
