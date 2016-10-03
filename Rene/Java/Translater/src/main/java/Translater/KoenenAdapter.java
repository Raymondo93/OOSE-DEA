package Translater;

import nl.oose.dea.koenenkramers.KoenenDictionary;

public class KoenenAdapter implements IDictionaryAdapter{
    public String translate(String word) {
        KoenenDictionary dictionary = new KoenenDictionary();
        dictionary.openEnglishDutch();
        return dictionary.lookUp(word);
    }
}
