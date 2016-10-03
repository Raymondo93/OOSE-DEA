package Translater;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TranslateAdapterTest {

    @Test
    public void testKoenenAdapter(){
        IDictionaryAdapter dictionary = DictionaryFactory.getDictionaryAdapter(DictionaryTypes.KOENEN);

        assertTrue(dictionary instanceof KoenenAdapter);
    }

    @Test
    public void testKramerAdapter(){
        IDictionaryAdapter dictionary = DictionaryFactory.getDictionaryAdapter(DictionaryTypes.KRAMERS);

        assertTrue(dictionary instanceof KramerAdapter);
    }

    @Test
    public void testInvalidArgument(){
        IDictionaryAdapter dictionary = DictionaryFactory.getDictionaryAdapter(null);

        assertEquals(null, dictionary);
    }
}
