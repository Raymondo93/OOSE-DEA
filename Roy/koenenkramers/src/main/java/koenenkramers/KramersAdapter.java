package koenenkramers;

import nl.oose.dea.koenenkramers.KramersDictionary;

/**
 * Created by royho on 3-10-2016.
 */
public class KramersAdapter implements Dictionary {
    public String getTranslation(String word) {
        KramersDictionary KD = new KramersDictionary();
        return KD.find(word);
    }
}
