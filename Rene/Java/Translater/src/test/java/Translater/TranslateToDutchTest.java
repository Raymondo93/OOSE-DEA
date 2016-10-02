package Translater;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TranslateToDutchTest {
    private TranslateToDutch translator;

    public static final String EnglishWordInBoth = "aeroplane";
    public static final String EnglishWordNotInKoenen = "submarine";
    public static final String EnglishWordNotInKramers = "whale";
    public static final String EnglishWordNotFound = "test";

    @Before
    public void setUp() {
        translator = new TranslateToDutch();
    }

    @Test
    public void testTranslateEnglishWordInBoth() {
        String translated = translator.translate(EnglishWordInBoth);

        assertEquals("vliegtuig", translated);
    }

    @Test
    public void testTEnglishWordNotInKoenen() {
        String translated = translator.translate(EnglishWordNotInKoenen);

        assertEquals("onderzeeboot", translated);
    }

    @Test
    public void testTtranslateEnglishWordNotInKramers(){
        String translated = translator.translate(EnglishWordNotInKramers);

        assertEquals("walvis", translated);
    }

    @Test
    public void testTranslateEnglishWordNotFound(){
        String translated = translator.translate(EnglishWordNotFound);

        assertEquals("", translated);
    }
}
