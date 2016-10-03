package Translater;

import nl.oose.dea.koenenkramers.KramersDictionary;

public class KramerAdapter implements IDictionaryAdapter{
    public String translate(String word) {
        KramersDictionary dictionary = new KramersDictionary();

        return dictionary.find(word);
    }
}
