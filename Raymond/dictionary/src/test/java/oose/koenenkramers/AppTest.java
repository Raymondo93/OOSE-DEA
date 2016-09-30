package oose.koenenkramers;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest 
 {
    private IDictionary dictionary = new DictionaryAdapter();


    /*
        Both dictionaries contains "car"
     */
    @Test
    public void testDictionaryLowerCase() {
        // input
        String testWord = dictionary.getWord("car");
        // test
        assertEquals("auto", testWord);
    }

    /*
        Both dictionaries contains "dog"
     */
    @Test
    public void testDictionaryUpperCase() {
        // input
        String testWord = dictionary.getWord("Dog");
        // test
        assertEquals("hond", testWord);
    }

    /*
        Test only dictionary koenen
     */
    @Test
    public void testKoenenDictionary() {
        // input
        String testWord = dictionary.getWord("whale");
        // test
        assertEquals("walvis", testWord);
    }

    /*
        Test only dictionary kramers
     */
    @Test
    public void testKramersDictionary() {
        // input
        String testWord = dictionary.getWord("fox");
        // test
        assertEquals("vos", testWord);
    }

}
