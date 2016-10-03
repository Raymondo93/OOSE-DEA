package koenenkramers;

import nl.oose.dea.koenenkramers.KoenenDictionary;

/**
 * Created by royho on 3-10-2016.
 */
public class KoenenAdapter implements Dictionary {
    public String getTranslation(String word) {
        KoenenDictionary KD = new KoenenDictionary();
        KD.openEnglishDutch();
        KD.openDutchEnglish();
        return KD.lookUp(word);
    }
}
