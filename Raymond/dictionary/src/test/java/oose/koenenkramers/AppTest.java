package oose.koenenkramers;

import nl.oose.dea.koenenkramers.KoenenDictionary;
import nl.oose.dea.koenenkramers.KramersDictionary;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * Unit test for simple App.
 */
public class AppTest 
 {

     private IDictionary dictionary = new DictionaryAdapter();

     /*

      */
     @Test
     public void testWord() {
         // input
         String test = dictionary.translate("car");
         // test
         assertEquals("auto", test);
     }
}
