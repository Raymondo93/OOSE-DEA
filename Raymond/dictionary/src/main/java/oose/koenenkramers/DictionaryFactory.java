package oose.koenenkramers;

/**
 * Created by Ray on 30/09/16.
 */
public class DictionaryFactory {
    private static IDictionary dictionary;
    public static IDictionary searchWord(String word) {
        dictionary.getWord(word);
        return dictionary;
    }
}
